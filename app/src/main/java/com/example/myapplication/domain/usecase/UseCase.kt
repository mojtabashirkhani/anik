package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repositoryImpl.PersonFoodRepositoryImpl
import com.example.myapplication.domain.model.Food
import com.example.myapplication.domain.model.Person
import com.example.myapplication.domain.model.PersonFoodCrossRef
import com.example.myapplication.domain.model.PersonWithFoods
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class GetAllPersonsWithFoodsUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    operator fun invoke(): Flow<List<PersonWithFoods>> {
        return repository.getAllPersonsWithFoods()
    }
}

class GetAllFoodsUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    operator fun invoke(): Flow<List<Food>> {
        return repository.getAllFoods()
    }
}

class AddPersonUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    suspend operator fun invoke(person: Person) {
        repository.insertPerson(person)
    }
}

class AddFoodUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    suspend operator fun invoke(food: Food) {
        repository.insertFood(food)
    }
}

class AddFavoriteFoodUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    suspend operator fun invoke(personId: Long, foodId: Long) {
        repository.insertPersonFoodCrossRef(PersonFoodCrossRef(personId, foodId))
    }
}

class DeleteFavoriteFoodUseCase @Inject constructor(private val repository: PersonFoodRepositoryImpl) {
    suspend operator fun invoke(personId: Long, foodId: Long) {
        repository.deletePersonFoodCrossRefById(personId, foodId)
    }
}