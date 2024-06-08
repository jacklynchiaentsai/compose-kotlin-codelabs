import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

// method that generates fake data
private fun getWellnessTasks() = List(30){
        i -> WellnessTask(i, "Task # $i")
}

class WellnessViewModel: ViewModel(){
    // define internal _tasks variable then expose tasks making it not modifiable from outside
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask){
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean){
        _tasks.find {it.id == item.id}?.let { task ->
            task.checked = checked
        }
    }

}