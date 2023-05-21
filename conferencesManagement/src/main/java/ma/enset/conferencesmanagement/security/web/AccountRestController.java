package ma.enset.conferencesmanagement.security.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import ma.enset.conferencesmanagement.security.JWTUtil;
import ma.enset.conferencesmanagement.entities.AppRole;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.security.services.IAppService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AccountRestController {
    private IAppService appService;

    public AccountRestController(IAppService appService) {
        this.appService = appService;
    }
    @GetMapping(path = "/users")
//    @PostAuthorize("hasAnyAuthority('USER')")
    public List<Participant> getAllUsers(){
        return appService.userList();
    }
    @GetMapping("/users/{userName}")
    public Participant getUser(@PathVariable String userName){
        return appService.getUser(userName);
    }
    @PostMapping("/users")
//    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public Participant addUser(@RequestBody Participant user){
        return appService.addNewUser(user);
    }
    @PostMapping("/roles")
    public AppRole addRole(@RequestBody AppRole role){
        return appService.addNewRole(role);
    }
    @PostMapping("/formUserRole")
    public Participant addRoleUser(String role, Principal principal){
        System.out.println(principal.getName());
        return appService.addRoleToUser(role,principal.getName());
    }
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authorizationToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if(authorizationToken!=null && authorizationToken.startsWith(JWTUtil.PREFIX)) {
            try {
                String jwt = authorizationToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String userName = decodedJWT.getSubject();
                Participant participant = appService.getUser(userName);
                String jwtAccessToken = JWT.create()
                        .withSubject(participant.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", participant.getUserRoles().stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> idToken = new HashMap<>();
                idToken.put("access-token", jwtAccessToken);
                idToken.put("refresh-token", jwt);
                response.setContentType("application/json");
                response.setHeader(JWTUtil.AUTH_HEADER, jwtAccessToken);
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);

            } catch (Exception e) {
                throw e;
            }
        }else {
            throw new RuntimeException("refresh token required");
        }
    }
}
@Data
class FormUserRole{
    private String userName;
    private String roleName;
}
