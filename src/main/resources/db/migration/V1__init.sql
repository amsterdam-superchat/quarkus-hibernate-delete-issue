create table thread
(
    id           uuid,
    workspace_id uuid,
    constraint ck__thread__workspace_id check ( workspace_id is not null ),
    constraint pk__thread__id primary key (id)
);

create table message
(
    id      uuid,
    content varchar,
    constraint fk__message__id foreign key (id) references thread (id),
    constraint pk__message__id primary key (id)
);

create table tagged_message
(
    id         uuid,
    message_id uuid,
    constraint ck__tagged_message__message_id check ( message_id is not null ),
    constraint fk__tagged_message__message_id foreign key (message_id) references message (id),
    constraint pk__tagged_message__id primary key (id)
);

insert into thread (id, workspace_id)
values ('ae1b6264-784b-4543-b20e-c13d913fc2f0', 'd0149697-69a2-4ca5-8f04-c894ee18472c');

insert into message (id, content)
values ('ae1b6264-784b-4543-b20e-c13d913fc2f0', 'message 1');

insert into thread (id, workspace_id)
values ('1ba7cc3d-0e27-4cb6-992f-5617d65bf444', 'd0149697-69a2-4ca5-8f04-c894ee18472c');

insert into message (id, content)
values ('1ba7cc3d-0e27-4cb6-992f-5617d65bf444', 'message 1');

insert into tagged_message (id, message_id)
values ('d2adad11-d5ee-4ce0-82f4-2449ec92bf07', 'ae1b6264-784b-4543-b20e-c13d913fc2f0');

insert into tagged_message (id, message_id)
values ('f9457bc4-b78a-4a8d-8b7f-ebe7f0e8b719', '1ba7cc3d-0e27-4cb6-992f-5617d65bf444');