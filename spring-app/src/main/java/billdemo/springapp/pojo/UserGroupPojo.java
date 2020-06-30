package billdemo.springapp.pojo;

import billdemo.springjpa.model.entity.User;
import billdemo.springjpa.model.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupPojo {

    protected String id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    private String groupId;
    private String groupName;
    private List<User> users;

    public static UserGroupPojo getUserPojo(UserGroup userGroup) {
        if (userGroup != null) {
            return UserGroupPojo.builder()
                    .groupId(userGroup.getGroupId())
                    .groupName(userGroup.getGroupName())
                    .users(userGroup.getUsers())
                    .id(userGroup.getId())
                    .createTime(userGroup.getCreateTime())
                    .updateTime(userGroup.getUpdateTime())
                    .build();
        } else {
            return null;
        }
    }

}
