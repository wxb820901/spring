package billdemo.springapp.pojo;

import billdemo.springjpa.model.entity.User;
import billdemo.springjpa.model.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPojo {
    protected String id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    private String userId;
    private String userName;
    private UserGroup userGroup;
    protected String name;
    protected Date birthday;

    public static UserPojo getUserPojo(User user) {
        if (user != null) {
            return UserPojo.builder()
                    .userGroup(user.getUserGroup())
                    .birthday(user.getBirthday())
                    .name(user.getName())
                    .userId(user.getUserId())
                    .userName(user.getUserName())
                    .id(user.getId())
                    .createTime(user.getCreateTime())
                    .updateTime(user.getUpdateTime())
                    .build();
        } else {
            return null;
        }
    }

}
