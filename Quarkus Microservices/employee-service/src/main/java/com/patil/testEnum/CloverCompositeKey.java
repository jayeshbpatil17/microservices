//package com.patil.testEnum;
//
//
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.*;
//import jakarta.persistence.Enumerated;
//
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Embeddable
//public class CloverCompositeKey implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Enumerated(EnumType.STRING)
//    private CloverEnum characterPart;
//
//    private int integerPart;
//
//    private static final AtomicInteger counter = new AtomicInteger(10000);
//
//    public CloverCompositeKey(CloverEnum characterPart) {
//        this.characterPart = characterPart;
//        this.integerPart = counter.getAndIncrement();
//    }
//
//
//    public CloverEnum getCharacterPart() {
//        return characterPart;
//    }
//
//    public int getIntegerPart() {
//        return integerPart;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CloverCompositeKey that = (CloverCompositeKey) o;
//        return integerPart == that.integerPart &&
//                characterPart == that.characterPart;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(characterPart, integerPart);
//    }
//
//    public CloverCompositeKey() {
//        // Default constructor for Hibernate
//    }
//
//
//
//
//
//
//}
//
