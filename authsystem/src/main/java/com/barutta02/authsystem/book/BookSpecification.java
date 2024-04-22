package com.barutta02.authsystem.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    /*
     * This method returns a Specification object that will be used to filter the books by their owner.
     
        Il metodo withOwnerId che hai fornito sembra essere una fabbrica di specifiche (Specification factory) utilizzata in Spring Data JPA. Le specifiche (Specification) in Spring Data JPA sono oggetti che consentono di definire criteri di ricerca dinamici per le query JPA.

        In questo caso, il metodo withOwnerId restituisce una specifica che cerca i libri in base all'ID del proprietario. Questo significa che è possibile utilizzare questa specifica per filtrare i libri in base all'ID del proprietario quando si esegue una query JPA.
     */
    public static Specification<Book> withOwnerId(Integer ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
