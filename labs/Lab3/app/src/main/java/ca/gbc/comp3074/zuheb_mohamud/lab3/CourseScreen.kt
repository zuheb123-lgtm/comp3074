package ca.gbc.comp3074.zuheb_mohamud.lab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseItem(course: Course) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Android,
            contentDescription = "Android Icon",
            modifier = Modifier.size(45.dp),
            tint = Color(0xFFFF0000)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
        ) {
            Text(
                text = course.code,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = course.name,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun SimpleCourseList(courses: List<Course>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 24.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        courses.forEach { course ->
            CourseItem(course)
            HorizontalDivider()
        }
    }
}

@Composable
fun LazyCourseList(courses: List<Course>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 24.dp)
    ) {
        item {
            Text(
                text = "Courses",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        items(courses) { course ->
            CourseItem(course)
            HorizontalDivider()
        }
    }
}

@Composable
fun CourseScreen() {
    val context = LocalContext.current

    val courses = remember {
        mutableStateListOf<Course>().apply {
            addAll(loadCourses(context))
        }
    }

    Column {
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val courseNumber = courses.size + 1

                val newCourse = Course(
                    code = "COMP$courseNumber",
                    name = "New Course $courseNumber"
                )

                courses.add(
                    index = 0,
                    element = newCourse
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon"
            )

            Text("Add Course")
        }

        //SimpleCourseList(courses)
        LazyCourseList(courses)
    }
}