-- Create the database
DROP TABLE IF EXISTS candidate;
DROP TABLE IF EXISTS voter;
DROP TABLE IF EXISTS admin;

CREATE DATABASE IF NOT EXISTS voting_system;
USE voting_system;

-- Admin table
CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

-- Insert default admin
INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

-- Voter table
CREATE TABLE IF NOT EXISTS voter (
    voter_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(50),
    has_voted BOOLEAN DEFAULT FALSE,
    age VARCHAR(10)
);

-- Candidate table
CREATE TABLE IF NOT EXISTS candidate (
    candidate_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    party VARCHAR(255),
    votes INT DEFAULT 0
);
