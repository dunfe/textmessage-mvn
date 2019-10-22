# TextMessage
 
Email spam, also known as junk email or unsolicited bulk email (UBE), is a subset of electronic spam involving nearly identical messages sent to numerous recipients by email. The messages may contain disguised links that appear to be for familiar websites but in fact lead to phishing web sites or sites that are hosting malware. Spam email may also include malware as scripts or other executable file attachments. Definitions of spam usually include the aspects that email is unsolicited and sent in bulk.

Many people, after a late night, for whatever reason, tend to send emails or text messages that they shouldn’t. Google has experimented with a feature that “blocks” these emails from being sent immediately. (What they do is ask the user some simple math questions before the send operation can execute. Their philosophy is that if someone can’t answer some simple math questions, then maybe the messages they are sending out aren’t the ones they would typically want to send out, under normal conditions.) You don’t want to get in trouble for stealing Google’s idea, but you’ve noticed that the same principle can be applied to text messages. In general, here is what you have noticed:
 
All text messages sent in between 7:00am and 12:59am (the next day) are reasonably sound messages. But, some messages in between 1:00am and 6:59am tend to be suspect. To reduce your workload, (since censoring requires reading through the whole message), you will ONLY censor messages sent in between 1:00am and 6:59am. All other messages are automatically sent without inspection.
 
When you inspect the messages sent in between 1:00am and 6:59am, you will censor (block) any message with the following characteristics:
 
1) The strings “I”, “love”, and “you” appear consecutively, in that order, in any capitalization
 
2) Three or more misspelled words (you will be given a dictionary of valid “text” words)
 
3) Has a forbidden word (you will be given a list of these as well)
 
All comparisons should be done case-insensitive.
 
Function details: 

•	The email content input from file txt. The first line of the input file will have a single positive integer, n (n ≤ 30000), representing the number of words in the dictionary. The next n lines will contain one word from the dictionary each, all in lowercase letters, listed in alphabetical order. (No word will be longer than 29 letters.)

•	The next line in the input file will have a single positive integer, m (m ≤ 100), representing the number of forbidden words. These will NOT be in the dictionary. The next m lines will have each of the forbidden words listed, all in lowercase, one word per line, in alphabetical order.

•	The following line of the input file will have a single positive integer, t, representing the number of text messages to examine. The rest of the file will contain 2t lines. The relevant information for each text message will be contained in 2 lines. The first line for each text message will contain a time listed in the following format:

hh:mm AM (or)

hh:mm PM

Note: two digits will be used to represent the hour, only when necessary, otherwise 1 digit will be used. There will always be a space after the time and either AM or PM, and the latter will always be capitalized as shown. This time represents when the user wants to send the text message.

•	The next line will contain a positive integer, w (w < 50), representing the number of words in the message, followed by the text message itself and is guaranteed just to contain strings with letters only separated by space.

•	For each message, output a header as follows:

Message #x:

where x (1 ≤ x ≤ t) is number of the text message. (Note: Always leave a space after the colon.)
If the message should be censored, then finish the line with the following string:
FAILED TO SEND.

Otherwise, simply put the original text of the message (in its original capitalization) to follow.
Separate the output for each case with a blank line.
Expectation of User interface:
 
Message #1: FAILED TO SEND.

Message #2: Jason I love you

Message #3: Jsoan I lve you

Message #4: FAILED TO SEND.

Message #5: Jason you jerk

#Vietnamese
TEXT MESSAGE

Thư rác, còn được gọi là email rác hoặc email hàng loạt không được yêu cầu (unsolicited bulk email UBE), là một tập hợp thư rác điện tử gần như giống hệt nhau được gửi đến nhiều người nhận qua email. Các tin nhắn có thể chứa các liên kết được ngụy trang dường như dành cho các trang web quen thuộc nhưng thực tế dẫn đến các trang web lừa đảo hoặc các trang web đang lưu trữ phần mềm độc hại. Email spam cũng có thể bao gồm phần mềm độc hại dưới dạng tập lệnh hoặc tệp đính kèm tệp thực thi khác. Các định nghĩa về thư rác thường bao gồm các khía cạnh về việc gửi hàng loạt những email không được yêu cầu.
Nhiều người, sau một đêm khuya, vì bất kỳ lý do gì, có xu hướng gửi email hoặc tin nhắn mà họ không nên gửi. Google đã thử nghiệm một tính năng để chặn việc các email được gửi ngay lập tức. (Những gì họ làm là hỏi người dùng một số câu hỏi toán học đơn giản trước khi thao tác gửi có thể thực thi. Triết lý của họ là nếu ai đó không thể trả lời một số câu hỏi toán học đơn giản, thì có thể những tin nhắn họ đang gửi không phải là những thứ họ thường muốn gửi đi, trong điều kiện bình thường.) Bạn không muốn gặp rắc rối vì ăn cắp ý tưởng của Google, nhưng bạn đã nhận thấy rằng nguyên tắc tương tự có thể được áp dụng cho tin nhắn văn bản. Nói chung, đây là những gì bạn đã nhận thấy:

Tất cả các tin nhắn văn bản được gửi trong khoảng thời gian từ 7:00 sáng đến 12:59 sáng (ngày hôm sau) là những tin nhắn hợp lệ. Nhưng, một số tin nhắn trong khoảng từ 1:00 sáng đến 6:59 sáng có xu hướng bị nghi ngờ. Để giảm khối lượng công việc của bạn, (vì kiểm duyệt yêu cầu đọc qua toàn bộ tin nhắn), bạn sẽ CHỈ cần kiểm duyệt các tin nhắn được gửi trong khoảng từ 1:00 sáng đến 6:59 sáng. Tất cả các tin nhắn khác được tự động gửi mà không cần kiểm tra.
Khi bạn kiểm tra các tin nhắn được gửi trong khoảng từ 1:00 đến 6:59 sáng, bạn sẽ kiểm duyệt (chặn) bất kỳ tin nhắn nào có các đặc điểm sau:
 
1) Các chuỗi “I”, “love”, và “you” xuất hiện liên tiếp, theo thứ tự đó, bất kể chữ cái nào được viết hoa.
 
2) Ba hoặc nhiều từ sai chính tả (bạn sẽ được cung cấp một từ điển các từ hợp lệ)
 
3) Có một từ bị cấm (bạn cũng sẽ được cung cấp một danh sách những từ này)
 
Tất cả các so sánh nên được thực hiện không phân biệt chữ hoa chữ thường.

Function details: 

• Nội dung email từ tệp txt. Dòng đầu tiên của tệp đầu vào sẽ có một số nguyên dương duy nhất, n (n ≤ 30000), đại diện cho số lượng từ trong từ điển. Mỗi dòng n tiếp theo sẽ chứa một từ trong từ điển, tất cả đều được viết bằng chữ thường, được liệt kê theo thứ tự bảng chữ cái. (Không có từ nào dài hơn 29 chữ cái.)

• Dòng tiếp theo trong tệp đầu vào sẽ có một số nguyên dương duy nhất, m (m 100), đại diện cho số lượng từ bị cấm. Những điều này sẽ KHÔNG có trong từ điển. Các dòng m tiếp theo sẽ có mỗi từ bị cấm được liệt kê, tất cả đều viết thường, một từ trên mỗi dòng, theo thứ tự bảng chữ cái.

• Dòng sau của tệp đầu vào sẽ có một số nguyên dương duy nhất, t, biểu thị số lượng tin nhắn văn bản cần kiểm tra. Phần còn lại của tệp sẽ chứa 2t dòng. Thông tin liên quan cho mỗi tin nhắn văn bản sẽ được chứa trong 2 dòng. Dòng đầu tiên cho mỗi tin nhắn văn bản sẽ chứa thời gian được liệt kê theo định dạng sau:

hh:mm AM (or)

hh:mm PM

Lưu ý: hai chữ số sẽ được sử dụng để thể hiện giờ, chỉ khi cần thiết, nếu không thì chỉ 1 chữ số được sử dụng. Sẽ luôn có một khoảng trắng sau thời gian và “AM” hoặc “PM”, và sẽ luôn được viết hoa như hình. Thời gian này là khi người dùng gửi tin nhắn văn bản.

• Dòng tiếp theo sẽ chứa một số nguyên dương, w (w <50), đại diện cho số lượng từ trong tin nhắn, theo sau là chính tin nhắn văn bản và được đảm bảo chỉ chứa các chuỗi các chữ cái chỉ cách nhau bởi khoảng trắng.

• Đối với mỗi tin nhắn, output phải có một tiêu đề như sau:

Message #x:

Trong đó x (1 ≤ x ≤ t) là số của tin nhắn văn bản. (Lưu ý: Luôn chừa một khoảng trắng sau dấu hai chấm.)

Nếu thông báo cần được kiểm duyệt, sau đó kết thúc dòng bằng chuỗi sau:

FAILED TO SEND.

Nếu không cần kiểm duyệt, chỉ cần in ra phiên bản gốc của tin nhắn.
Xuống dòng sau mỗi tin nhắn. 

Expectation of User interface:
 
Message #1: FAILED TO SEND.

Message #2: Jason I love you

Message #3: Jsoan I lve you

Message #4: FAILED TO SEND.

Message #5: Jason you jerk





