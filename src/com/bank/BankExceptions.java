package com.bank;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { super(message); }
}
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) { super(message); }
}