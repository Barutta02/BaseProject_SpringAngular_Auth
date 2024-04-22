package com.barutta02.authsystem.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/*
 * The repository interface for the Book entity.
 * It extends the JpaRepository interface, which provides CRUD operations for the entity.
 * It also extends the JpaSpecificationExecutor interface, which provides support for dynamic queries.
 JpaSpecificationExecutor permette di eseguire query dinamiche su un'entità. Questo significa che è possibile creare query in modo dinamico in base a criteri specifici, come filtri, ordinamenti e altre condizioni. Questo è utile quando si desidera eseguire query complesse con criteri variabili.
Permette nel service di usare il findAll() con la specificazione*/
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    /*
     * This method is used to find all books that are not archived and are shareable and not owned by the user
    
        Il parametro pageable nel metodo findAllDisplayableBooks è utilizzato per specificare i dettagli della paginazione dei risultati della query. Quando si esegue una query che potrebbe restituire un gran numero di risultati, la paginazione è utile per suddividere i risultati in pagine più piccole, facilitando la navigazione e il recupero dei dati.

        Il parametro pageable è di tipo Pageable, che è un'interfaccia fornita da Spring Data utilizzata per configurare le opzioni di paginazione, come il numero di pagina, la dimensione della pagina, l'ordinamento e altre opzioni.
     */
    @Query("""
            SELECT book
            FROM Book book
            WHERE book.archived = false
            AND book.shareable = true
            AND book.owner.id != :userId
            """)
    Page<Book> findAllDisplayableBooks(Pageable pageable, Integer userId);
}
