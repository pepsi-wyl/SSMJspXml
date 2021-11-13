package pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/10/9.09点46分
 * books实体类
 */

@Alias("books")

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Component
@Scope("singleton")

public class Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
