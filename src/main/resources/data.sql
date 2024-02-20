BEGIN TRANSACTION;

INSERT INTO "public"."post" (
        "comments",
        "high_fives",
        "shares",
        "id",
        "image",
        "text",
        "user_id"
    )
VALUES (
        51,
        12,
        9,
        'b89078a8-9175-4157-9fe8-e2a916e1d31d',
        'https://i.ibb.co/4Yr7z0J/image.png',
        'this is a high-five with a cosmic hand',
        'e02acbc4-2e43-4dfe-8637-467d6b3b1074'
    ),
    (
        9,
        13,
        26,
        '505fb765-0669-4b91-9706-6d50c6c0efea',
        'https://i.ibb.co/1Rzxj4B/image.jpg',
        'this is a high-five with a mechanical hand',
        '1075de58-5fa4-439e-8da0-59cdc6927618'
    ),
    (
        15,
        123,
        23,
        '75caf9ac-f654-4aa9-b7af-d654f1585822',
        'https://i.ibb.co/v38Zyks/image.jpg',
        'this is a high-five with a robot',
        'ead598f0-7a55-4266-a5d5-40e56ec19b88'
    ),
    (
        5,
        13,
        2,
        '7346f722-3796-461f-826a-48f92119a5a4',
        'https://i.ibb.co/pz2dWyC/image.jpg',
        'this is a high-five with a cat',
        '2b147a04-64b1-4cc9-9522-596c3e459917'
    ),
    (
        6,
        7,
        21,
        '21a4e983-dd97-485e-ba6f-427b5cd81e6c',
        'https://i.ibb.co/Z8YdR2N/image.png',
        'this is a high-five with a lizard',
        'e02acbc4-2e43-4dfe-8637-467d6b3b1074'
    ),
    (
        52,
        3,
        12,
        '0e027798-0a4f-43cd-bb4b-445160b43412',
        'https://i.ibb.co/WFLHKHm/image.png',
        'this is a high-five with an eagle',
        '1075de58-5fa4-439e-8da0-59cdc6927618'
    ),
    (
        523,
        1223,
        2322,
        '8fd2c3bb-4e2f-47d8-940a-9451eb9380c7',
        'https://i.ibb.co/VTMfYzP/image.png',
        'this is a high-five with a crab',
        '2b147a04-64b1-4cc9-9522-596c3e459917'
    ),
    (
        52,
        131,
        2112,
        '439b2837-75c6-4347-83c5-90a853fe98de',
        'https://i.ibb.co/y6k9K57/image.png',
        'this is an attempt to high-five with a fish',
        'ead598f0-7a55-4266-a5d5-40e56ec19b88'
    ),
    (
        15,
        14,
        20,
        '611877f5-ee1b-4190-978a-53636a297bc1',
        'https://i.ibb.co/gP4LDPn/image.png',
        'this is an attempt to high-five with an elephant',
        'e02acbc4-2e43-4dfe-8637-467d6b3b1074'
    ),
    (
        511,
        3,
        12,
        'f7560a00-9a13-4f4e-97d9-9e622970649d',
        'https://i.ibb.co/Ksfwpms/image.png',
        'this is a high-five with a bear',
        '1075de58-5fa4-439e-8da0-59cdc6927618'
    );

COMMIT;