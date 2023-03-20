package festival.api.model.dto.user;

import festival.api.model.collection.user.User;
import org.bson.types.ObjectId;

import java.util.Objects;

public class UserDto {

    private ObjectId id;
    private boolean admin;
    private String firstName;
    private String lastName;
    private String email;
    private String token;


    public UserDto() { }

    public UserDto(User user) {
        this.id = user.getId();
        this.admin = user.isAdmin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public UserDto(User user, String token) {
        this(user);
        this.token = token;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return admin == userDto.admin && Objects.equals(id, userDto.id) && Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(email, userDto.email) && Objects.equals(token, userDto.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, admin, firstName, lastName, email, token);
    }
}
