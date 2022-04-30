create table if not exists `article` (
    `article_id` bigint primary key not null,
    `contents` varchar(255) not null,
    `likes` int not null
    );