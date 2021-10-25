package com.example.mycompose

import android.net.Uri

class NavigationRepository {
    fun getNavigations(): List<QuickNavigation> {
        return listOf(
            QuickNavigation(
                image = R.drawable.ic_badgessuvblack,
                "Request a ride on Uber",
                "Strata Apartments to San Francisco Marriott Marquis",
                Uri.parse("https://m.uber.com/looking?drop%5B0%5D=%7B%22id%22%3A%22c8a04f89-375e-7cba-9545-b32f554276b4%22%2C%22addressLine1%22%3A%22San%20Francisco%20Marriott%20Marquis%22%2C%22addressLine2%22%3A%22780%20Mission%20St%2C%20San%20Francisco%2C%20California%22%2C%22provider%22%3A%22uber_places%22%2C%22locale%22%3A%22en-US%22%2C%22latitude%22%3A37.785023%2C%22longitude%22%3A-122.40481%7D&pickup=%7B%22label%22%3A%22%22%2C%22addressLine1%22%3A%22Strata%20Apartments%22%2C%22addressLine2%22%3A%22555%20Mission%20Rock%20St%2C%20San%20Francisco%2C%20California%22%2C%22latitude%22%3A37.7728338%2C%22longitude%22%3A-122.3906821%7D&state=i81t62qYnGa2ys8TU5Lb-WIMB8e0hraXu6jQHaJfT_M%3D&vehicle=a1111c8c-c720-46c3-8534-2fcdd730040d")
            ),

            QuickNavigation(
                image = R.drawable.profile_picture,
                "Request a ride on Uber",
                "Palace of Fine Arts to Fisherman's Wharf",
                Uri.parse("https://m.uber.com/looking?drop%5B0%5D=%7B%22id%22%3A%22ChIJueOuefqAhYARapAU-YtbztA%22%2C%22addressLine1%22%3A%22Fisherman%27s%20Wharf%22%2C%22addressLine2%22%3A%22San%20Francisco%2C%20CA%22%2C%22provider%22%3A%22google_places%22%2C%22locale%22%3A%22en%22%2C%22latitude%22%3A37.8071509%2C%22longitude%22%3A-122.4155954%7D&pickup=%7B%22id%22%3A%22ChIJgUYUENWGhYAR9awaWIrbYOk%22%2C%22addressLine1%22%3A%22The%20Palace%20Of%20Fine%20Arts%22%2C%22addressLine2%22%3A%223601%20Lyon%20St%2C%20San%20Francisco%2C%20CA%22%2C%22provider%22%3A%22google_places%22%2C%22locale%22%3A%22en%22%2C%22latitude%22%3A37.801577%2C%22longitude%22%3A-122.4477802%7D&state=i81t62qYnGa2ys8TU5Lb-WIMB8e0hraXu6jQHaJfT_M%3D&vehicle=a1111c8c-c720-46c3-8534-2fcdd730040d")
            ),

            QuickNavigation(
                image = R.drawable.ic_badgessuvblack,
                "Request a ride on Uber",
                "Golden Gate Bridge to Academy of Science",
                Uri.parse("https://m.uber.com/looking?drop%5B0%5D=%7B%22id%22%3A%22ChIJGaZ-9eB9j4ARqGe7yh7Jm0Y%22%2C%22addressLine1%22%3A%22Academy%20of%20Arts%20and%20Sciences%22%2C%22addressLine2%22%3A%22555%20Portola%20Dr%2C%20San%20Francisco%2C%20CA%22%2C%22provider%22%3A%22google_places%22%2C%22locale%22%3A%22en%22%2C%22latitude%22%3A37.745959200107855%2C%22longitude%22%3A-122.44973236689677%7D&pickup=%7B%22id%22%3A%22ChIJw____96GhYARCVVwg5cT7c0%22%2C%22addressLine1%22%3A%22Golden%20Gate%20Bridge%22%2C%22addressLine2%22%3A%22San%20Francisco%2C%20CA%22%2C%22provider%22%3A%22google_places%22%2C%22locale%22%3A%22en%22%2C%22latitude%22%3A37.8199286%2C%22longitude%22%3A-122.4782551%7D&state=i81t62qYnGa2ys8TU5Lb-WIMB8e0hraXu6jQHaJfT_M%3D&vehicle=a1111c8c-c720-46c3-8534-2fcdd730040d")
            ),
        )
    }
}