package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
@RequiredArgsConstructor of Lombok creates a constructor with arguments
that are based on the class' fields that annotated "@NotNull"
*/
@RequiredArgsConstructor
public class Node<T> {

    @Getter
    @NonNull
    private T _data;
    @Getter
    @Setter
    private Node<T> _next;
    @Getter
    @Setter
    private Node<T> _prev;
}
