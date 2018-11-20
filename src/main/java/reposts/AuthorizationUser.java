package reposts;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import reposts.core.dto.RoleDTO;
import reposts.core.dto.UserDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorizationUser implements UserDetails {

    private final String password;
    private final String login;

    private final List<? extends GrantedAuthority> authorities;

    public AuthorizationUser(UserDTO userDTO) {
        password = userDTO.getPasswordHash();
        login = userDTO.getLogin();
        authorities = getAuthorities(userDTO.getRoles());
//        authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    public List<GrantedAuthority> getAuthorities(List<RoleDTO> roles){
        System.out.println("Call method List<GrantedAuthority> in Authorization");
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for(RoleDTO role: roles){
            System.out.println("Roles list: " + role.getName());
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}