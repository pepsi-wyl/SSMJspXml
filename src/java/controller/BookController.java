
package controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Books;
import service.BookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/10/10.10点54分
 */

@Controller
@Scope("singleton")

@RequestMapping(value = "/book")
public class BookController {

    //javax下的注解
    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    /**
     * 展示所有书籍
     */
    @RequestMapping(value = "/allBook")
    public String queryBookList(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        model.addAttribute("queryName", "请输入要查询的书籍名称");
        return "jsp/allBook";
    }

    /**
     * 查询书籍ByBookName
     */
    @RequestMapping(value = "/queryBook", method = RequestMethod.POST)
    public String queryBookByBookName(String queryBookName, Model model) {
        List<Books> books = bookService.getBookByBookName(queryBookName.trim());   //去除空格
        model.addAttribute("bookList", books);
        if (books.isEmpty()) {               //没有查到书
            model.addAttribute("error", "没有查到数据!!!");
        } else {
            if (queryBookName == "") {
                model.addAttribute("queryName", "请输入要查询的书籍名称");
            } else {
                model.addAttribute("queryName", queryBookName);
            }
        }
        return "jsp/allBook";
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping(value = "/toAddBook")
    public String toAddBook() {
        return "jsp/addBook";
    }

    /**
     * 添加书籍
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * 跳转到修改书籍
     */
    @RequestMapping(value = "/toUpdatePager")
    public String toUpdatePager(@Param("id") int id, Model model) {
        Books book = bookService.getBookByID(id);
        model.addAttribute("book", book);
        return "jsp/updateBook";
    }

    /**
     * 修改书籍
     */
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Books book) {
        System.out.println(bookService.updateBookByID(book) > 0 ? "修改成功!" : "修改失败!");
        return "redirect:/book/allBook";
    }

    /**
     * 删除书籍
     */
    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable int id) {
        System.out.println(bookService.delBookByID(id) > 0 ? "删除成功!" : "删除失败!");
        return "redirect:/book/allBook";
    }

}
