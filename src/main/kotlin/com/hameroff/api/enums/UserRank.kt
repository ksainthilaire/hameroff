package com.hameroff.api.enums

enum class UserRank {
    // Guest user who registered on the store
    CLIENT,

    // Support agent who manages the follow-up of orders, and answers customer questions
    SUPPORT,

    // Store administrator who can manage the entire store
    ADMINISTRATOR,

    // Guest who can make a quick purchase in anonymous mode without registering
    GUEST
}