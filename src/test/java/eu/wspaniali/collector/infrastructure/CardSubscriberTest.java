package eu.wspaniali.collector.infrastructure;

class CardSubscriberTest {


    private static final String cardAsJson = """
        {
            "id": "a4bd6d9a-942d-53a3-8607-2354f86cc810",
            "layout": "normal",
            "name": "Steel Golem",
            "names": null,
            "manaCost": "{3}",
            "cmc": 3.0,
            "colors": null,
            "colorIdentity": null,
            "type": "Artifact Creature â€” Golem",
            "supertypes": null,
            "types": [
                "Artifact",
                "Creature"
            ],
            "subtypes": [
                "Golem"
            ],
            "rarity": "Uncommon",
            "text": "You can't cast creature spells.",
            "originalText": "You can't play creature spells.",
            "flavor": "\\"Once you create perfection, what else is there to make?\\"\\nâ€”Arcum Dagsson, Soldevi machinist",
            "artist": "Donato Giancola",
            "number": "344",
            "power": "3",
            "toughness": "4",
            "loyalty": null,
            "multiverseid": 135235,
            "variations": null,
            "imageName": null,
            "watermark": null,
            "border": null,
            "timeshifted": false,
            "hand": 0,
            "life": 0,
            "reserved": false,
            "releaseDate": null,
            "starter": false,
            "set": "10E",
            "setName": "Tenth Edition",
            "printings": [
                "10E",
                "WTH"
            ],
            "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=135235&type=card",
            "legalities": [
                {
                    "format": "Commander",
                    "legality": "Legal"
                },
                {
                    "format": "Duel",
                    "legality": "Legal"
                },
                {
                    "format": "Legacy",
                    "legality": "Legal"
                },
                {
                    "format": "Modern",
                    "legality": "Legal"
                },
                {
                    "format": "Oathbreaker",
                    "legality": "Legal"
                },
                {
                    "format": "Paupercommander",
                    "legality": "Restricted"
                },
                {
                    "format": "Penny",
                    "legality": "Legal"
                },
                {
                    "format": "Predh",
                    "legality": "Legal"
                },
                {
                    "format": "Premodern",
                    "legality": "Legal"
                },
                {
                    "format": "Vintage",
                    "legality": "Legal"
                }
            ],
            "priceHigh": null,
            "priceMid": null,
            "priceLow": null,
            "onlinePriceHigh": null,
            "onlinePriceMid": null,
            "onlinePriceLow": null,
            "rulings": [
                {
                    "date": "2004-10-04",
                    "text": "You can put creatures onto the battlefield by means other than casting them."
                },
                {
                    "date": "2004-10-04",
                    "text": "Yes, this only affects you."
                },
                {
                    "date": "2008-04-01",
                    "text": "A â€œcreature spellâ€ is any spell with the type Creature, even if it has other types such as Artifact or Enchantment. Older cards of type Summon are also Creature spells."
                }
            ],
            "foreignNames": [
                {
                    "name": "Stahlgolem",
                    "text": "Du kannst keine Kreaturenzauber spielen.",
                    "flavor": "â€žSobald man Perfektion erschaffen hat, was hat man dann noch fÃ¼r ein Ziel?\\" â€”Arcum Dagsson, Soldevischer Maschinist",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=148720&type=card",
                    "language": "German",
                    "multiverseId": 0
                },
                {
                    "name": "GÃ³lem de acero",
                    "text": "No puedes jugar hechizos de criatura.",
                    "flavor": "\\"Â¿Una vez que has creado la perfecciÃ³n, quÃ© te queda por hacer?\\" â€”Arcum Dagsson, mecÃ¡nico soldevi",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=150660&type=card",
                    "language": "Spanish",
                    "multiverseId": 0
                },
                {
                    "name": "Golem d'acier",
                    "text": "Vous ne pouvez pas jouer de sorts de crÃ©ature.",
                    "flavor": "Â« Une fois que vous avez crÃ©Ã© la perfection, que vous reste-t-il Ã  accomplir ? Â» â€”Arcum Dagsson, machiniste soldevi",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=150277&type=card",
                    "language": "French",
                    "multiverseId": 0
                },
                {
                    "name": "Golem d'Argento",
                    "text": "Non puoi giocare magie creatura.",
                    "flavor": "\\"Una volta creata la perfezione, cos'altro c'Ã¨ da fare?\\" â€”Arcum Dagsson, macchinista di Soldevi",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=149103&type=card",
                    "language": "Italian",
                    "multiverseId": 0
                },
                {
                    "name": "é‹¼ã®ã‚´ãƒ¼ãƒ¬ãƒ ",
                    "text": "ã‚ãªãŸã¯ã‚¯ãƒªãƒ¼ãƒãƒ£ãƒ¼å‘ªæ–‡ã‚’ãƒ—ãƒ¬ã‚¤ã§ããªã„ã€‚",
                    "flavor": "å®Œç’§ã‚’ä½œã‚Šä¸Šã’ãŸã‚‰ã€ã‚‚ã†ä½œã‚‹ã‚‚ã®ãªã©ã‚ã‚‹ã®ã‹ã­ï¼Ÿ â€•â€•ã‚½ãƒ«ãƒ‡ãƒ´ã‚£ã®æ©Ÿæ¢°é­”è¡“å¸«ã€ã‚¢ãƒ¼ã‚«ãƒ ãƒ»ãƒ€ã‚°ã‚¹ãƒ³",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=148337&type=card",
                    "language": "Japanese",
                    "multiverseId": 0
                },
                {
                    "name": "Golem de AÃ§o",
                    "text": "VocÃª nÃ£o pode jogar mÃ¡gicas de criatura.",
                    "flavor": "\\"Uma vez que vocÃª cria a perfeiÃ§Ã£o, o que resta a ser feito?\\" â€” Arcum Dagsson, maquinista soldeviano",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=149894&type=card",
                    "language": "Portuguese (Brazil)",
                    "multiverseId": 0
                },
                {
                    "name": "Ð¡Ñ‚Ð°Ð»ÑŒÐ½Ð¾Ð¹ Ð“Ð¾Ð»ÐµÐ¼",
                    "text": "Ð’Ñ‹ Ð½Ðµ Ð¼Ð¾Ð¶ÐµÑ‚Ðµ Ñ€Ð°Ð·Ñ‹Ð³Ñ€Ñ‹Ð²Ð°Ñ‚ÑŒ Ð·Ð°ÐºÐ»Ð¸Ð½Ð°Ð½Ð¸Ñ ÑÑƒÑ‰ÐµÑÑ‚Ð².",
                    "flavor": "\\"ÐŸÐ¾ÑÐ»Ðµ Ñ‚Ð¾Ð³Ð¾, ÐºÐ°Ðº Ñ‚Ñ‹ ÑÐ¾Ñ‚Ð²Ð¾Ñ€Ð¸Ð» ÑÐ°Ð¼Ð¾ ÑÐ¾Ð²ÐµÑ€ÑˆÐµÐ½ÑÑ‚Ð²Ð¾, Ñ‡ÐµÐ³Ð¾ ÐµÑ‰Ñ‘ Ð¼Ð¾Ð¶Ð½Ð¾ Ð´Ð¾ÑÑ‚Ð¸Ñ‡ÑŒ?\\" â€” ÐÑ€ÐºÑƒÐ¼ Ð”Ð°Ð³ÑÑÐ¾Ð½, ÑÐ¾Ð»ÑŒÐ´ÐµÐ²ÑÐºÐ¸Ð¹ Ð¼ÐµÑ…Ð°Ð½Ð¸Ðº",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=149511&type=card",
                    "language": "Russian",
                    "multiverseId": 0
                },
                {
                    "name": "é’¢é“é­”åƒ",
                    "text": "ä½ ä¸èƒ½ä½¿ç”¨ç”Ÿç‰©å’’è¯­ã€‚",
                    "flavor": "ã€Œé€ å‡ºå®Œç¾Žä¹‹åŽï¼Œä½ è¿˜èƒ½ä½œäº›ä»€ä¹ˆï¼Ÿã€ ï½žç´¢åœ°å¨å·¥åŒ é˜¿è‚¯Â·è¾¾æ ¼æ£®",
                    "imageUrl": "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=147954&type=card",
                    "language": "Chinese Simplified",
                    "multiverseId": 0
                }
            ]
        }
        """;
}
