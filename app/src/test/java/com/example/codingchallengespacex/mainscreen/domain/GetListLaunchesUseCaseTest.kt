package com.example.codingchallengespacex.mainscreen.domain

class GetListLaunchesUseCaseTest {

    /*@RelaxedMockK
    private lateinit var repository: IListLaunchesRepository

    lateinit var getListLaunchesUseCase: GetLaunchesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getListLaunchesUseCase = GetLaunchesUseCase(repository)
    }

    @Test
    fun `when the api return something then get values`() = runBlocking {
        //Given
        val myList = UIState.Success(listOf(
            LaunchItem(
                name = "Elon",
                date_utc = "test",
                id = "12345",
                details = "Elon musk launches",
                image = "http://image.com"
            )
        ))
        coEvery { repository.getList() } returns myList

        //When
        val result = getListLaunchesUseCase()

        //Then
        assert(result == myList)
    }*/
}