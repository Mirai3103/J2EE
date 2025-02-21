-- Create the database (in SQLite this is done by just connecting to a new file)

-- Create the Flowers table
CREATE TABLE Flowers (
    flowerid VARCHAR(10) PRIMARY KEY,
    flowerName TEXT NOT NULL,
    unit TEXT NOT NULL,
    price REAL NULL,
    priceold REAL NOT NULL,
    brief TEXT,
    description TEXT,
    picture TEXT,
    createdate DATE,
    active INTEGER  -- SQLite doesn't have BIT, using INTEGER as boolean (0/1)
);

-- Insert data
INSERT INTO Flowers (flowerid, flowerName, unit, price, priceOld, brief, description, picture, createdate, active) 
VALUES 
('B01', 'Hi Vọng Xanh', 'Bó', 650000, 0, 'Sự kết hợp đơn giản của tông màu xanh lá như một bức tranh một khu vườn nhỏ đầy sức sống . Mang lại cảm giác thoải mái, thư giãn khi ngắm nhìn đóa hoa này. Tượng trưng cho sự phát triển, tràn đầy hy vọng tương lai tươi sáng, sinh sôi nảy nở trong sự nghiệp. Thích hợp tặng những dịp khai trương, ngày thành lập.', 'Bó hoa gồm: - 10 Hồng trắng nhí - 5 Hoa Cúc Lưới Xanh - 5 Green wicky - 5 Cúc calimero xanh - 3 Cát tường trắng - 3 Cúc mai xanh', '10676_hi-vong-xanh.png', date('now'), 1),

('B02', 'NHẸ NHÀNG', 'Bó', 650000, 0, 'Đóa hoa kết hợp sắc trắng và màu tím hoàn mỹ có sức thu hút mạnh mẽ , tượng trưng sự gắn bó và bên nhau lâu dài, gặp nhiều niềm vui, nhiều sức khỏe và luôn luôn hạnh phúc trong cuộc sống . Thích hợp tặng sinh nhật, dịp lễ đặc biệt.', 'Bó hoa gồm: - 11 Hồng tím cà - 5 Cẩm chướng đơn tím - 10 Đồng tiền hồng nhí - 2 Cúc lưới tím - 5 Cúc mai hồn', '10677_nhe-nhang.png', date('now'), 1),

('B03', 'SẮC HOA', 'Bó', 750000, 0, 'Sự kết hợp siêu đáng yêu của tone tím và cam nhẹ nhàng của hoa hồng, bó hoa như cây kẹo ngọt làm rung động trái tim người nhận. Đây sẽ là món quà đặc biệt cùng với biểu tượng của sự ngọt ngào, lãng mạn với tình yêu chân thành. Thích hợp tặng những dịp sinh nhật, ngày lễ tình nhân.', 'Bó hoa gồm: - 7 Hồng trứng gà - 4 Hồng sen mới - 5 Hồng tím nhí - 5 Hồng da - 2 Hồng da cồ - 5 Cúc calimero tím', '10675_sac-hoa.png', date('now'), 1),

('H01', 'LA VIE EN ROSE', 'Hộp', 900000, 0, 'Hộp hoa được thiết kế nhã nhặn với những màu sắc tươi thắm của những đoá hoa hồng. Thông điệp của lòng yêu mến, biết ơn và lời cảm ơn chân thành nhất. Hộp hoa thích hợp tặng dịp lễ ngày nhà giáo Việt Nam 20/11, dành tặng các quý thầy cô', ' Gồm 3 Hồng red naomi  8 Hồng da 12 Hồng vàng ánh trăng', '10686_la-vie-en-rose.png', date('now'), 1),

('H02', 'FEELING', 'Hộp', 1050000, 0, 'Bạn đã bao giờ đặt một bó hoa gửi đến người yêu thương, thân thuộc chẳng vì một lí do nào cả? Chỉ đơn giản là hành động của cảm xúc? Nhưng chắc chắn rằng, đằng sau cái "chẳng vì một lí do gì" là những ấm áp yêu thương rất đỗi nhẹ nhàng', ' Gồm -16 Hồng đỏ ớt - 14 Hồng trứng gà - 7 Cẩm chướng đơn viền cam', '10682_feeling.png', date('now'), 1),

('H03', 'MÂY TÍM', 'Hộp', 1200000, 0, 'Hộp hoa mang vẻ đẹp rực rỡ sắc màu tím trang trọng, quý phái. Thể hiện tình cảm chân thành của học trò dành đến thầy cô với lòng biết ơn, tri ân sâu sắc. Thích hợp dành tặng dịp lễ ngày nhà giáo Việt Nam 20/11, dành tặng đến quý thầy cô.', 'Hộp hoa gồm có: - 15 Hồng tím cà - 12 Cúc ping pong hồng - 8 Lan bò cạp - 10 Lan Moka tím - 7 Cúc calimero tím', '10684_may-tim.png', date('now'), 1),

('G01', 'YÊU ĐỜI', 'Giỏ', 790000, 0, 'Giỏ hoa mang màu sắc ấm áp và rực rỡ gồm hồng đỏ ớt, hồng trứng, hướng dương thể hiện một tình cảm nồng nhiệt nhưng đầy tự hào của người tặng đối với người nhận. Giỏ hoa phù hợp với những người cá tính mạnh mẽ và quyết đoán.', 'Giỏ hoa gồm có: - 7 Hồng đỏ ớt - 10 Mõm sói vàng - 7 Hồng trứng gà - 5 Cúc ping pong xanh - 10 Cẩm chướng đơn vàng - 5 Hướng dương', '10687_yeu-doi.png', date('now'), 1),

('G02', 'VÌ EM', 'Giỏ', 750000, 0, 'Mỗi loại hoa Hồng mang một ý nghĩa thì "Vì em" chính là một món quà đến từ những bông Hồng tuyệt đẹp nhất mang theo thông điệp của những ý nghĩa bất ngờ. Đó là một cách tuyệt vời để khiến bữa sinh nhật được tỏa sáng, thêm gia vị cho những dịp kỉ niệm hay đơn giản chỉ muốn tạo nên những ngày đáng nhớ trong cuộc đời người tặng.', 'Giỏ hoa bao gồm các loại hoa: - 6 Mõm sói vàng - 13 Hồng đỏ ớt - 10 Hồng trứng gà - 6 Cúc calimero trắng xịt cam - 1 Cành Hoa baby', '10688_vi-em.png', date('now'), 1),

('G03', 'THE BEST OF LUCK', 'Giỏ', 1350000, 0, 'Giỏ hoa thiết kế đan xen giữa hoa đồng tiền, hoa hồng sắc cam,... nổi bật trên nền xanh của lá cây hòa quyện với tông màu cam rực rỡ, cành hoa phía trên đỉnh giỏ hoa như cánh chim tung bay khắp trời xanh. Tượng trưng cho sự sung túc, giàu sang , dồi dào về tiền bạc. Thích hợp những dịp lễ khai trương, kỷ niệm thành lập.', 'Giỏ hoa gồm có: - 11 Hồng trứng gà - 9 Hồng vàng ánh trăng - 5 Hoa thiên điểu - 10 Mõm sói vàng - 8 Hướng dương - 8 Lan vũ nữ', '10415_the-best-of-luck.png', date('now'), 1),

('BH01', 'LOVE AND ROSE', 'Bình', 550000, 0, 'Bình hoa nhỏ để bàn nổi bật với sự kết hợp hài hòa của cánh hồng đỏ red naomi và trắng tinh khiết làm cho căn phong thêm mới mẻ, đầy màu sắc. Bình hoa biểu tượng cho một tình yêu hạnh phúc, ấm no, sung túc và tràn đầy tiếng cười vui.', 'Bình hoa bao gồm các loại hoa: - 10 Mõm sói vàng - 9 Hồng da - 6 Hồng đỏ sa - 1 Hồng red naomi - 5 Cúc calimero tím - 1 Hoa baby', '10690_love-and-rose.png', date('now'), 1),

('BH02', 'ITS YOU', 'Bình', 580000, 0, 'Một ngày dạo trên phố, chợt thấy từng khóm hoa trong nắng đung đưa như mời gọi. Lấy ý tưởng từ những bông hoa nắng đó, bó hoa được thiết kế với tông màu cam đào sáng, tươi vui và nhẹ nhàng. Thích hợp tặng sinh nhật, chúc mừng, kỉ niệm.', 'Bình hoa gồm có:- 13 Hồng trứng gà - 12 Hồng trắng nhí - 10 Cúc calimero trắng', '10691_its-you.png', date('now'), 1),

('BH03', 'NGÀY HỒNG TƯƠI', 'Bình', 1280000, 0, 'Bình hoa được kết hợp khéo léo giữa hoa hồng, hoa ly và hoa đồng tiền với tone màu hồng phấn tươi mới, thể hiện một vẻ đẹp đáng yêu, rực rỡ . Sự kết hợp này gửi gắm sự nhẹ nhàng, sâu lắng, đôi khi là sự vui tươi. Bình hoa thích hợp tặng sinh nhật, kỉ niệm ngày quan trọng nào đó trong năm.', 'Bình hoa gồm có: - 15 Hồng da cồ - 8 Hồng tím nhí - 18 Mõm sói song hỷ - 10 Đồng tiền hồng nhí - 5 Lily hồng', '10418_ngay-hong-tuoi.png', date('now'), 1),

('CB01', 'VỀ NƠI XA', 'Kệ', 1580000, 0, 'Bước chân ra đi bỏ lại sau lưng những giọt nước mắt tiễn biệt mãi mãi. Người đi về nơi xa bỏ lại nơi đây là nỗi đau mất người thân luôn là nỗi đau khó quên đối với mỗi người chúng ta. Thấu hiểu niềm đau đó kệ hoa này sẽ là lời chia buôn sâu sắc đến gia quyến người đã khuất.', 'Kệ hoa chia buồn Về Nơi Xa gồm các loại hoa tươi: - 8 Lily trắng - 30 Hồng trắng nhí - 10 Môn trắng - 10 Cúc trắng - 2 Hoa baby', '5125_ve-noi-xa.jpg', date('now'), 1),
('CB02', 'HAI THẾ GIỚI 2', 'Kệ', 1480000, 0, 'Trong cuộc sống khi chúng ta mất đi vĩnh viễn một người thân hay người bạn thì luôn để lại nỗi đau xót khôn cùng cho người ở lại. Kệ chia buồn " Hai thế giới" với tone màu vàng - màu của phật pháp được thiết kế để chia buồn với gia chủ theo tôn giáo phật. Chúng tôi sẽ thay mặt bạn đưa tiễn họ và chia sẻ cùng gia đình.', 'Kệ hoa chia buồn Hai Thế Giới gồm các loại hoa: - 20 Mõm sói trắng - 25 Hồng trắng nhí - 18 Đồng tiền vàng - 20 Cẩm chướng đơn vàng - 20 Cúc calimero vàng - 10 Cúc trắng', '8397_hai-the-gioi-2.png', date('now'), 1),

('CB03', 'DEEP CONDOLENCES', 'Kệ', 880000, 0, 'Chuyện nhân gian vui buồn đều có. Kiếp nhân sinh như gió thoáng qua. Sinh ra trong một kiếp con người. Sớm ở tối về là lẽ thường thôi…Với vòng hoa chia buồn này chúng tôi sẽ thay mặt bạn đưa tiễn họ và chia sẻ sự mất mát cùng gia đình họ.', 'Kệ hoa tang "Deepest condolences" gồm có: - 15 Cúc trắng - 15 Cúc mai hồng', '8396_deep-condolences.png', date('now'), 1),

('CM01', 'TẤT THẮNG', 'Lãng', 1280000, 0, 'Trong phong thủy màu vàng rất thích hợp cho hỷ sự, lễ hội. Nó còn tượng trưng cho năng lượng Hỏa và sức mạnh... Kệ hoa chúc mừng được các florist đầu tư một cách nghiêm túc vì chúng tôi luôn hiểu rằng đó là uy tín của khách hàng, của cả một doanh nghiệp. Chúng tôi luôn nhận được sự yêu quý từ khách hàng, đặc biệt là các doanh nghiệp tin yêu và đặt thiết kế hoa chúc mừng phục vụ các dịp khai trương, khánh thành, tổ chức sự kiện và trong các dịp lễ quan trọng khác.', 'Kệ hoa gồm có:- 20 Đồng tiền vàng - 18 Hồng vàng ánh trăng - 15 Lily vàng thơm - 5 Lan vũ nữ', '10427_tat-thang.png', date('now'), 1),

('CM02', 'HƯNG THỊNH 5', 'Kệ', 1280000, 0, 'Kệ hoa chúc mừng Hưng Thịnh gồm có hoa hồng, đồng tiền và hoa hồng môn. Được xem là màu may mắn nhất, màu đỏ rất thích hợp cho hỷ sự, lễ hội. Nó còn tượng trưng cho năng lượng Hỏa và sức mạnh... Kệ hoa chúc mừng được chúng tôi đầu tư một cách nghiêm túc vì chúng tôi luôn hiểu rằng đó là uy tín của khách hàng, của cả một doanh nghiệp. Vì vậy, chúng tôi luôn nhận được sự tin tưởng từ khách hàng, đặc biệt là các doanh nghiệp tin yêu và đặt thiết kế hoa chúc mừng phục vụ các dịp khai trương, khánh thành, tổ chức sự kiện và trong các dịp lễ quan trọng khác.', 'Kệ chúc mừng Hưng Thịnh 5 gồm các loại hoa tươi: - 40 Hồng đỏ sa - 18 Hồng đỏ ớt - 10 Môn đỏ - 20 Đồng tiền đỏ', '2999_hung-thinh-5.jpg', date('now'), 1),

('CM03', 'PHỒN VINH', 'Kệ', 1980000, 0, 'Kệ hoa chúc mừng "Phồn vinh" như chính ý nghĩa của nó giàu có, thịnh vượng,là lời chúc cho sự phát triển tốt đẹp. Tone màu hồng của hoa ly và hoa đồng tiền chắc chắn sẽ là món quà tặng đặc biệt dành cho khai trương, kỷ niệm thành lập công ty, chúc mừng đối tác.', 'Kệ chúc mừng Phồn Vinh gồm các loại hoa tươi: - 15 Lily hồng - 17 Môn xanh - 30 Đồng tiền hồng nhí - 20 Mõm sói song hỷ', '5525_phon-vinh.jpg', date('now'), 1);

-- Create an index on flowerid if needed
CREATE INDEX idx_flowerid ON Flowers(flowerid);