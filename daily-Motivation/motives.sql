use motivational;

INSERT INTO motivational (quote, author, image_path, content, created_at, updated_at, published_at)
VALUES 
('The world will not be destroyed by those who do evil, but by those who watch them without doing anything'
	, 'Albert Einstein', 'images/1.jpg', 
	'', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE),
    
('However difficult life may seem, there is always something you can do and succeed at.'
	, 'Stephen Hawking', 'images/stephan.jpg', 
	'', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL 1 DAY),
    
("What we know is a drop, what we don't know is an ocean."
	,'Isaac Newton', 'images/issac.jpg', 
    '', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL 2 DAY),
    
('Life is not easy for any of us. But what of that? We must have perseverance and above all confidence in ourselves. We must believe that we are gifted for something, and that this thing, at whatever cost, must be attained.'
	,'Marie Curie', 'images/2.jpg', 
    '', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL 3 DAY),
    
("We can't control our destiny, but we can control who we become."
	,'Anne Frank', 'images/3.jpg', 
    '', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL 4 DAY);