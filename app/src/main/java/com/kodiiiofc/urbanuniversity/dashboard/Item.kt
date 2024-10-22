package com.kodiiiofc.urbanuniversity.dashboard

class Item(val title: String, val iconResource: Int, val fragment: ClickableCard) {
    companion object {
        val items = listOf(
            Item("Профиль", R.drawable.ic_profile, ProfileFragment()),
            Item("Задачи", R.drawable.ic_tasks, TasksFragment()),
            Item("Почта", R.drawable.ic_mail, MailFragment()),
            Item("Проект", R.drawable.ic_diagram, ProjectFragment()),
        )
    }
}