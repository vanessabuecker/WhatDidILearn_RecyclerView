package com.vbuecker.whatdidilearn.data

class LearnedItemDataBase {

    fun getAll(): List<LearnedItem> {

        return listOf(
            LearnedItem(
                name = "Kotlin",
                description = "Linguagem kotlin para Android",
                understandingLevel = UnderstandingLevel.MEDIUM
            ),
            LearnedItem(
                name = "RecyclerView",
                description = "Listas em Android",
                understandingLevel = UnderstandingLevel.MEDIUM
            ),
            LearnedItem(
                name = "DataClass",
                description = "Kotlin data Class",
                understandingLevel = UnderstandingLevel.HIGH
            ),
            LearnedItem(
                name = "Life Cycle",
                description = "Ciclo de vida de uma aplicação Android",
                understandingLevel = UnderstandingLevel.HIGH
            ),
            LearnedItem(
                name = "Intent",
                description = "Como usar intents",
                understandingLevel = UnderstandingLevel.MEDIUM
            ),
            LearnedItem(
                name = "Services",
                description = "Service em  Android",
                understandingLevel = UnderstandingLevel.MEDIUM
            ),
            LearnedItem(
                name = "Content Provider",
                description = "Dados com Contenct Provider",
                understandingLevel = UnderstandingLevel.LOW
            ),
        )
    }

}