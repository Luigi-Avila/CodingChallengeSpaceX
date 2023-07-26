package com.example.codingchallengespacex.mainscreen.ui

class ListLaunchesViewModelTest {

    /*@RelaxedMockK
    private lateinit var getListLaunchesUseCase: GetLaunchesUseCase

    lateinit var listLaunchesViewModel: ListLaunchesViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        listLaunchesViewModel = ListLaunchesViewModel(getListLaunchesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `When view model is created at first time, loading`() = runTest {
        //Given
        val myList = listOf(
            LaunchItem(
                image = "testing",
                details = "Elon musk image",
                name = "Elon musk",
                date_utc = "Today",
                id = "1234"
            )
        )
        val myResult = UIState.Success(myList)

        coEvery { getListLaunchesUseCase() } returns myResult

        //When
        listLaunchesViewModel.getListLaunches()
        delay(100)

        //Then
        assertEquals(UIState.Loading, listLaunchesViewModel._listLaunch.value)
    }*/

}