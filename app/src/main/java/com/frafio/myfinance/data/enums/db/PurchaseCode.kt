package com.frafio.myfinance.data.enums.db

import com.frafio.myfinance.utils.getCurrentLanguage

enum class PurchaseCode(val code: Int, val message: String) {
    EMPTY_NAME(
        1, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Enter the purchase name."
            Languages.ITALIANO.value -> "Inserisci il nome dell'acquisto."
            else -> "Enter the purchase name." // english
        }
    ),

    EMPTY_PRICE(
        2, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Enter the purchase price."
            Languages.ITALIANO.value -> "Inserisci il costo dell'acquisto."
            else -> "Enter the purchase price." // english
        }
    ),

    WRONG_NAME_TOTAL(
        3, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "The purchase name can't be 'Total'."
            Languages.ITALIANO.value -> "L'acquisto non può chiamarsi 'Totale'."
            else -> "The purchase name can't be 'Total'." // english
        }
    ),

    EMPTY_CATEGORY(
        4, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Enter the purchase category."
            Languages.ITALIANO.value -> "Inserisci la categoria dell'acquisto."
            else -> "Enter the purchase category." // english
        }
    ),

    PURCHASE_ADD_SUCCESS(
        10, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase added!"
            Languages.ITALIANO.value -> "Acquisto aggiunto!"
            else -> "Purchase added!" // english
        }
    ),

    PURCHASE_ADD_FAILURE(
        11, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase not added!"
            Languages.ITALIANO.value -> "Acquisto non aggiunto!"
            else -> "Purchase not added!" // english
        }
    ),

    PURCHASE_EDIT_SUCCESS(
        20, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase edited!"
            Languages.ITALIANO.value -> "Acquisto modificato!"
            else -> "Purchase edited!" // english
        }
    ),

    PURCHASE_EDIT_FAILURE(
        21, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase not edited!"
            Languages.ITALIANO.value -> "Acquisto non modificato!"
            else -> "Purchase not edited!" // english
        }
    ),

    PURCHASE_DELETE_SUCCESS(
        30, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase deleted!"
            Languages.ITALIANO.value -> "Acquisto eliminato!"
            else -> "Purchase deleted!" // english
        }
    ),

    PURCHASE_DELETE_FAILURE(
        31, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Purchase not deleted correctly!"
            Languages.ITALIANO.value -> "Acquisto non eliminato correttamente!"
            else -> "Purchase not deleted correctly!" // english
        }
    ),

    PURCHASE_LIST_UPDATE_SUCCESS(
        40, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "List updated!"
            Languages.ITALIANO.value -> "Lista aggiornata!"
            else -> "List Updated!" // english
        }
    ),

    PURCHASE_LIST_UPDATE_FAILURE(
        41, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "List not updated!"
            Languages.ITALIANO.value -> "Lista non aggiornata!"
            else -> "List not updated!" // english
        }
    ),

    PURCHASE_AGGREGATE_SUCCESS(
        50, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Aggregation query successful!"
            Languages.ITALIANO.value -> "Query di aggregazione riuscita!"
            else -> "Aggregation query successful!" // english
        }
    ),

    PURCHASE_AGGREGATE_FAILURE(
        51, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Aggregation query failed!"
            Languages.ITALIANO.value -> "Query di aggregazione non riuscita!"
            else -> "Aggregation query failed!" // english
        }
    ),

    PURCHASE_COUNT_SUCCESS(
        52, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Count query successful!"
            Languages.ITALIANO.value -> "Query di conteggio riuscita!"
            else -> "Count query successful!" // english
        }
    ),

    PURCHASE_COUNT_FAILURE(
        53, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Count query failed!"
            Languages.ITALIANO.value -> "Query di conteggio non riuscita!"
            else -> "Count query failed!" // english
        }
    ),

    BUDGET_UPDATE_SUCCESS(
        62, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Budget updated!"
            Languages.ITALIANO.value -> "Budget aggiornato"
            else -> "Budget updated!" // english
        }
    ),

    BUDGET_UPDATE_FAILURE(
        63, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Budget not updated!"
            Languages.ITALIANO.value -> "Budget non aggiornato"
            else -> "Budget not updated!" // english
        }
    ),

    INCOME_LIST_UPDATE_SUCCESS(
        70, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income list updated!"
            Languages.ITALIANO.value -> "Lista delle entrate aggiornata!"
            else -> "Income list updated!" // english
        }
    ),

    INCOME_LIST_UPDATE_FAILURE(
        71, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income list not updated!"
            Languages.ITALIANO.value -> "Lista delle entrate non aggiornata!"
            else -> "Income list not updated!" // english
        }
    ),

    INCOME_ADD_SUCCESS(
        72, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income added!"
            Languages.ITALIANO.value -> "Entrata aggiunta!"
            else -> "Income added!" // english
        }
    ),

    INCOME_ADD_FAILURE(
        73, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income not added!"
            Languages.ITALIANO.value -> "Entrata non aggiunta!"
            else -> "Income not added!" // english
        }
    ),

    INCOME_DELETE_SUCCESS(
        74, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income deleted!"
            Languages.ITALIANO.value -> "Entrata eliminata!"
            else -> "Income deleted!" // english
        }
    ),

    INCOME_DELETE_FAILURE(
        75, when (getCurrentLanguage()) {
            Languages.ENGLISH.value -> "Income not deleted correctly!"
            Languages.ITALIANO.value -> "Entrata non eliminata correttamente!"
            else -> "Income not deleted correctly!" // english
        }
    )
}