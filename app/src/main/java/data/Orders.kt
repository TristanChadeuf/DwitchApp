package data


import model.Ingredient
import model.Order
import model.Store
import model.UsersPermissionsUser


//val ingredients = listOf(
//    Ingredient(
//        id = 48,
//        documentId = "emqcpowwchz5ync8yri10g1e",
//        name = "Chou rouge mariné",
//        description = "Croquant et acidulé, il donne un twist coloré et savoureux à chaque bouchée.",
//        isVegan = true,
//        isSpicy = false,
//        kind = "topping",
//        createdAt = "2024-11-04T19:53:38.633Z",
//        updatedAt = "2024-11-04T20:20:30.657Z",
//        publishedAt = "2024-11-04T20:20:30.755Z"
//    ),
//    Ingredient(
//        id = 9,
//        documentId = "lc8a81ogo9x4qkrji2jny7c5",
//        name = "Jambon Cru",
//        description = "Raffiné et savoureux, avec une touche de sel et de caractère, ce jambon cru relève chaque bouchée avec un charme méditerranéen.",
//        isVegan = null,
//        isSpicy = null,
//        kind = "main",
//        createdAt = "2024-11-04T19:36:38.209Z",
//        updatedAt = "2024-11-04T19:36:38.209Z",
//        publishedAt = "2024-11-04T19:36:38.294Z"
//    ),
//    Ingredient(
//        id = 54,
//        documentId = "x2p6w1juycux47d3lpgrmxqe",
//        name = "Oignons caramélisés",
//        description = "Doux et sucrés, ils apportent une touche de gourmandise et un parfum irrésistible.",
//        isVegan = true,
//        isSpicy = false,
//        kind = "topping",
//        createdAt = "2024-11-04T19:45:26.858Z",
//        updatedAt = "2024-11-04T20:22:18.097Z",
//        publishedAt = "2024-11-04T20:22:18.181Z"
//    ),
//    Ingredient(
//        id = 56,
//        documentId = "k8f12xmyxlkhibobf86pos77",
//        name = "Pain Ciabatta",
//        description = "Léger et aéré avec une croûte légèrement croustillante, idéal pour un sandwich méditerranéen.",
//        isVegan = true,
//        isSpicy = false,
//        kind = "bread",
//        createdAt = "2024-11-04T20:00:05.268Z",
//        updatedAt = "2024-11-04T20:22:43.618Z",
//        publishedAt = "2024-11-04T20:22:43.726Z"
//    )
//)
//// Utilisateur
//val user = UsersPermissionsUser(
//    id = 1,
//    documentId = "vpfsc4adv76ynm2pqu5sm6i9",
//    username = "campus",
//    email = "campus@numerique.fr",
//    provider = "local",
//    confirmed = true,
//    blocked = false,
//    createdAt = "2024-11-10",
//    updatedAt = "2024-11-10",
//    publishedAt = "2024-11-10"
//)
//
//// Magasin
//val store = Store(
//    id = 2,
//    documentId = "gy0rgplj9kw945qydeaamjvd",
//    name = "Dwitch Bonlieu ",
//    isOpen = false,
//    city = "Annecy",
//    zipCode = "74000",
//    createdAt = "2024-11-10T14:07:03.541Z",
//    updatedAt = "2024-11-10T14:07:03.541Z",
//    publishedAt = "2024-11-10T14:07:03.690Z"
//)
//
//
//val orders = listOf(
//    Order(
//        id = 3,
//        documentId = "xh37i6xd42rfv2qijl57mjgj",
//        placedAt = "2024-11-10",
//        receivedAt = "2024-11-10",
//        cookMessage = "Avec maaaaassse Oignons caramélisés please",
//        price = 12,
//        progress = 100,
//        createdAt = "2024-11-10",
//        updatedAt = "2024-11-11",
//        publishedAt = "2024-11-11",
//        ingredients = ingredients,
//        users_permissions_user = user,
//        store = store
//    ),
//    Order(
//        id = 4,
//        documentId = "ab12cd34ef56gh78ij90klmn",
//        placedAt = "2024-12-01",
//        receivedAt = "2024-12-01",
//        cookMessage = "Sans gluten, extra sauce s'il vous plaît",
//        price = 18,
//        progress = 75,
//        createdAt = "2024-12-01",
//        updatedAt = "2024-12-01",
//        publishedAt = "2024-12-01",
//        ingredients = ingredients,
//        usersPermissionsUser = user,
//        store = store
//    ),
//    Order(
//            id = 5,
//    documentId = "ab12cd34ef56gh78ij90klmn",
//    placedAt = "2024-12-01",
//    receivedAt = "2024-12-01",
//    cookMessage = "Sans gluten, extra sauce s'il vous plaît",
//    price = 18,
//    progress = 75,
//    createdAt = "2024-12-01",
//    updatedAt = "2024-12-01",
//    publishedAt = "2024-12-01",
//    ingredients = ingredients,
//    usersPermissionsUser = user,
//    store = store
//    ),
//    Order(
//        id = 6,
//        documentId = "xh37i6xd42rfv2qijl57mjgj",
//        placedAt = "2024-11-10",
//        receivedAt = "2024-11-10",
//        cookMessage = "Avec maaaaassse Oignons caramélisés please",
//        price = 12,
//        progress = 100,
//        createdAt = "2024-11-10",
//        updatedAt = "2024-11-11",
//        publishedAt = "2024-11-11",
//        ingredients = ingredients,
//        usersPermissionsUser = user,
//        store = store
//    ),
//    Order(
//        id = 7,
//        documentId = "ab12cd34ef56gh78ij90klmn",
//        placedAt = "2024-12-01",
//        receivedAt = "2024-12-01",
//        cookMessage = "Sans gluten, extra sauce s'il vous plaît",
//        price = 18,
//        progress = 75,
//        createdAt = "2024-12-01",
//        updatedAt = "2024-12-01",
//        publishedAt = "2024-12-01",
//        ingredients = ingredients,
//        usersPermissionsUser = user,
//        store = store
//    ),
//)