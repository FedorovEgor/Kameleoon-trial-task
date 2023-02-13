package com.back.portal.enums;

public enum ErrorMessagesEnum {
    NO_USER_FOUND("No user with passed Id found."),
    NO_QUOTE_FOUND("No quote with passed Id found."),
    NO_VOTE_FOUND("No vote with passed Id found."),
    SELF_VOTE_ERR("You can't vote for your own quote!"),
    EXISTING_VOTE_ERR("You have already voted for this quote with same reaction!"),
    USER_ALREADY_EXISTS("User with this email already exists!"),
    EMPTY_QUOTES("There are no quotes posted.");

    public final String value;

    ErrorMessagesEnum(String value) {
        this.value = value;
    }
}
