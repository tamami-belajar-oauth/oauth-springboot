package lab.aikibo.oauthauthserver.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tamami on 05/09/17.
 */
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Users byUsername) {
        this.username = byUsername.getUsername();
        this.password = byUsername.getPassword();

        List<GrantedAuthority> auths = new ArrayList<>();
        for(Role role: byUsername.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }

        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
