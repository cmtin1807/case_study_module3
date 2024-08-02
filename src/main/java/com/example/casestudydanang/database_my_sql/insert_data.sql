USE book_manager;

INSERT INTO category(category_name)
values ('Ngôn Tình');
INSERT INTO category(category_name)
values ('Tiên Hiệp');
INSERT INTO category(category_name)
values ('Sách Giáo Khoa');

INSERT INTO Publisher(publisher_name)
values ('Kim Đồng');
INSERT INTO Publisher(publisher_name)
values ('Hà Nội');
INSERT INTO Publisher(publisher_name)
values ('Bộ Giáo Dục');


INSERT INTO book(name, description, image_url, status, category_id, publisher_id)
values ('Giáo Dục Công Dân 8', 'Giáo dục công dân lớp 8',
        'https://i.pinimg.com/564x/22/57/b7/2257b7c7dcd5387cad2d4aab74ce85fa.jpg', 0, 3, 3),
       ('Vạn Cổ Đệ Nhất Thần', 'Tu Tiên hay nhất',
        'https://i.pinimg.com/736x/63/89/65/638965c51846a4e4c747ef54c7f0df47.jpg', 0, 2, 2),
       ('Hắc Ám Tây Du', 'Tu Tiên hay nhất Thế giới',
        'https://i.pinimg.com/736x/a3/30/6e/a3306e62640b4a4b0133c44761576500.jpg', 0, 2, 2);


