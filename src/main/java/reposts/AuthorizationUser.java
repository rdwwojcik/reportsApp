package reposts;

import reposts.core.dto.UserDTO;
import reposts.core.entities.Role;
import reposts.core.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public List<GrantedAuthority> getAuthorities(List<Role> roles){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for(Role role: roles){
            authorityList.add(new SimpleGrantedAuthority(role.getRole()));
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