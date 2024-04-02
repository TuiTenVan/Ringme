USE quanlylaixebus;

DROP TABLE IF EXISTS drivers;

CREATE TABLE drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phonenumber VARCHAR(20),
    qualification VARCHAR(255)
);

DROP TABLE IF EXISTS routes;

CREATE TABLE routes (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    distance DOUBLE NOT NULL,
    numberofstops INT NOT NULL
);

DROP TABLE IF EXISTS assignments;

CREATE TABLE assignments (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    driver_id INT NOT NULL,
    route_id INT NOT NULL,
    numberoftrips INT NOT NULL,
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id),
    FOREIGN KEY (route_id) REFERENCES Routes(route_id)
);
