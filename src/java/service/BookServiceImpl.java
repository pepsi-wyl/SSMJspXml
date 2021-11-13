
package service;

import mapper.BookMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Books;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/10/9.13点49分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAspectJAutoProxy

@Service
@Scope("singleton")

//编写事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = 10)

public class BookServiceImpl implements BookService {

    @Resource(name = "bookMapper")
    private BookMapper bookMapper;

    @Override
    public List<Books> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public Books getBookByID(int bookID) {
        return bookMapper.getBookByID(bookID);
    }

    @Override
    public List<Books> getBookByBookName(String bookName) {
        return bookMapper.getBookByBookName(bookName);
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int delBookByID(int bookID) {
        return bookMapper.delBookByID(bookID);
    }

    @Override
    public int updateBookByID(Books book) {
        return bookMapper.updateBookByID(book);
    }


}

