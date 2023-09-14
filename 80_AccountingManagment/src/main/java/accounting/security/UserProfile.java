package accounting.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserProfile extends User {
    private boolean passwordIsNotExpired;

    public UserProfile(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean passwordIsNotExpired) {
        super(username, password, authorities);
        this.passwordIsNotExpired = this.passwordIsNotExpired;
    }

    public boolean isPasswordIsNotExpired() {
        return passwordIsNotExpired;
    }
}

