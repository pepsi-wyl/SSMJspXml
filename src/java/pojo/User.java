
package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/10/16.10点14分
 */

@Alias("user")

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Component
@Scope("singleton")

public class User {
    int id;
    String userName;
    String password;
}

