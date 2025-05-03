CREATE DATABASE voting_system;

-- Admin table
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

-- Insert default admin
INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

-- Voter table
CREATE TABLE voter (
    voter_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(50),
    has_voted BOOLEAN DEFAULT FALSE,
    age VARCHAR(10)
);

-- Candidate table
CREATE TABLE candidate (
    candidate_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    party VARCHAR(255),
    votes INT DEFAULT 0
);
