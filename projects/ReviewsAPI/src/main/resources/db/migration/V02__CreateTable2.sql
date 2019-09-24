create table comments(
    commentID int(11) not null auto_increment,
    reviewID int(11) not null,
    content varchar(300) not null,
    primary key (commentID),
    foreign key (reviewID) references reviews (reviewID)
);