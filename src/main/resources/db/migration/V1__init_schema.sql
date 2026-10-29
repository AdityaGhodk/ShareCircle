CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       full_name VARCHAR(255),
                       email VARCHAR(255),
                       password VARCHAR(255),
                       phone VARCHAR(255),
                       role VARCHAR(255),
                       active BOOLEAN,
                       created_at DATETIME(6)
);

CREATE TABLE items (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255),
                       description VARCHAR(255),
                       category VARCHAR(255),
                       price DOUBLE,
                       `condition` VARCHAR(255),
                       location VARCHAR(255),
                       image_url VARCHAR(255),
                       status VARCHAR(255),
                       created_at DATETIME(6)
);

CREATE TABLE bookings (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id BIGINT,
                          item_id INT,
                          start_date DATE,
                          end_date DATE,
                          total_price DOUBLE,
                          security_deposit DOUBLE,
                          status VARCHAR(255),
                          created_at DATETIME(6)
);

CREATE TABLE reviews (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT,
                         item_id INT,
                         rating INT,
                         comment VARCHAR(255),
                         created_at DATETIME(6)
);

CREATE TABLE categories (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255),
                            description VARCHAR(255)
);
