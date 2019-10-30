package com.thanhsonitnic.ungdungdocsach.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thuở còn là sinh viên, mình cũng từng có những thắc mắc, trăn trở về kĩ thuật, về con đường nghề nghiệp, nhưng không có ai giải đáp.\n" +
                "Là một lập trình viên, các bạn cần học rất nhiều, nhưng không sách vở nào nói về cách tự học cho hiệu quả.\n" +
                "Lập trình viên cần biết cách giao tiếp và làm việc nhóm, nhưng ít thầy cô nói cho các bạn biết điều này.\n" +
                "Lập trình viên cần phải giỏi tiếng Anh, nhưng hầu như đi làm rồi các bạn mới tự nhận ra.\n" +
                "Không biết những điều này, bạn sẽ phải hứng chịu vô số gạch đá trên con đường nghề nghiệp.\n" +
                "Do vậy, chúng ta cần những đầu sách định hướng nghề nghiệp và những kĩ năng phải có của người lập trình viên. Tuy nhiên, đa phần sách cho dân IT hiện nay quá tập trung vào kĩ thuật và công nghệ (kĩ năng cứng), quên mất những kĩ năng mềm mà lập trình viên nên có. Những quyển sách trên cũng khá hàn lâm và khô cứng, khó tiếp thu.\n" +
                "\n" +
                "Cuốn sách này không như thế! Vậy nó có gì hot?\n" +
                "Đây là cuốn sách duy nhất tập trung vào phần kĩ năng mềm mà mỗi lập trình viên cần có.\n" +
                "Đi kèm với chúng những kĩ năng cứng được đúc kết qua kinh nghiệm bao năm làm việc của tác giả.\n" +
                "Thay cho những chương sách dày cộm toàn chữ, nội dung sách được chia làm nhiều bài viết ngắn gọn, mỗi bài viết đề cập đến một khía cạnh khác nhau.\n" +
                "Giọng văn ngắn gọn, hài hước dí dỏm, đọc không hề cứng nhắc như sách kĩ thuật mà lại rất dễ tiếp thu.Nếu các bạn có đọc các blog về lập trình ở Việt Nam thì có lẽ cái tên Tôi đi code dạo không có gì quá xa lạ đối với các bạn.\n" +
                "\n" +
                "Về tác giả của blog Tôi đi code dạo, anh tên thật là Phạm Huy Hoàng, một Developer Full Stack, cựu sinh viên trường FPT University, hiện tại anh đang học Thạc sĩ Computer Science tại Đại học Lancaster ở Anh (học bổng $18000). Trước khi qua Xứ Sở Sương Mù, anh đã từng làm việc tại FPT Software và ASWIG Solutions.\n" +
                "\n" +
                "Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách “Code dạo ký sự – lập trình viên đâu phải chỉ biết code”.\n" +
                "\n" +
                "Hiện tại, trên thị trường sách Việt Nam với chủ đề về IT nói chung và lập trình viên nói riêng đều rất khan hiếm, chủ yếu là dịch lại từ tác giả nước ngoài. Chúng ta đã quá mải mê vào những đầu sách dạng “Những cách làm giàu hay đại loại vậy” đã khiến chúng ta ảo tưởng phần nào về bản thân mà thật sự kỹ năng của bạn không cho phép để làm điều đó.\n" +
                "\n" +
                "Vì thế chúng ta cần những đầu sách để định hướng nghề nghiệp và xây dựng kiến thức thật vững chắc, khi đó bạn mới có thể nghĩ tới những điều tuyệt vời hơn trong tương lai. “Code dạo ký sự – lập trình viên đâu phải chỉ biết code” sẽ đem lại cho bạn điều đó.\n" +
                "\n" +
                "Một số sách công nghệ hiện nay quá khô cứng, tập trung nhiều vào kĩ thuật nên khó tiếp thu. Số sách cò lại đa phần là về thuật toán, khá cũ, hoặc tập trung vào một công nghệ, rất mau hết hạn.\n" +
                "\n" +
                "Cuốn sách này hoàn toàn khác những cuốn sách về IT và công nghệ trên thị thường. Vậy nó có điểm nào đặc biệt?\n" +
                "\n" +
                "Những bài viết ngắn gọn và thú vị về những kĩ năng mềm và cứng mà một lập trình viên phải có, được mình rút chiết qua bao kinh nghiệm xương máu.\n" +
                "Giọng văn hài hước dí dỏm, đọc không hề giống sách kĩ thuật nhưng lại dễ tiếp thu.\n" +
                "Sách tập trung vào khả năng tự học và định hướng người đọc. Có kĩ năng tự học, có định hướng tốt, bạn sẽ dễ dàng sống sót và thăng tiến trong ngành này.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}