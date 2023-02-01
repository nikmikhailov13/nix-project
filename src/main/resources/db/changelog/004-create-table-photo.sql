CREATE TABLE nikitamykhailov.nix.photo(
                                          id BIGINT NOT NULL PRIMARY KEY,
                                          url VARCHAR(255) NOT NULL,
                                          student_id BIGINT NOT NULL,
                                          FOREIGN KEY (student_id) REFERENCES nikitamykhailov.nix.student(id)
);