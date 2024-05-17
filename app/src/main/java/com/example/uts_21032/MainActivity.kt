package com.example.spinnerintentapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerYear: Spinner
    private lateinit var spinnerHour: Spinner
    private lateinit var spinnerMinute: Spinner
    private lateinit var buttonOk: Button
    private lateinit var editTextTitle: EditText
    private lateinit var radioGroupWatchFor: RadioGroup
    private lateinit var checkBoxThriller: CheckBox
    private lateinit var checkBoxHorror: CheckBox
    private lateinit var checkBoxAction: CheckBox
    private lateinit var checkBoxRomance: CheckBox
    private lateinit var checkBoxComedy: CheckBox
    private lateinit var checkBoxFantasy: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerYear = findViewById(R.id.spinner_year)
        spinnerHour = findViewById(R.id.spinner_hour)
        spinnerMinute = findViewById(R.id.spinner_minute)
        buttonOk = findViewById(R.id.btn_ok)
        editTextTitle = findViewById(R.id.et_title)
        radioGroupWatchFor = findViewById(R.id.rg_watch_for)
        checkBoxThriller = findViewById(R.id.cb_thriller)
        checkBoxHorror = findViewById(R.id.cb_horror)
        checkBoxAction = findViewById(R.id.cb_action)
        checkBoxRomance = findViewById(R.id.cb_romance)
        checkBoxComedy = findViewById(R.id.cb_comedy)
        checkBoxFantasy = findViewById(R.id.cb_fantasy)

        // tahun
        val years = (2000..2024).map { it.toString() }.toTypedArray()
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = yearAdapter

        // jam
        val hours = (0..23).map { it.toString() }.toTypedArray()
        val hourAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hours)
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHour.adapter = hourAdapter

        // menit
        val minutes = (0..59).map { it.toString() }.toTypedArray()
        val minuteAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, minutes)
        minuteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMinute.adapter = minuteAdapter

        buttonOk.setOnClickListener {
            val title = editTextTitle.text.toString()
            val selectedYear = spinnerYear.selectedItem.toString()
            val selectedHour = spinnerHour.selectedItem.toString()
            val selectedMinute = spinnerMinute.selectedItem.toString()

            val watchFor = when (radioGroupWatchFor.checkedRadioButtonId) {
                R.id.rb_adult -> "Adult (17+)"
                R.id.rb_kids -> "Kids"
                else -> ""
            }

            val selectedGenres = mutableListOf<String>()
            if (checkBoxThriller.isChecked) selectedGenres.add("Thriller")
            if (checkBoxHorror.isChecked) selectedGenres.add("Horror")
            if (checkBoxAction.isChecked) selectedGenres.add("Action")
            if (checkBoxRomance.isChecked) selectedGenres.add("Romance")
            if (checkBoxComedy.isChecked) selectedGenres.add("Comedy")
            if (checkBoxFantasy.isChecked) selectedGenres.add("Fantasy")

            val message = """
                Title: $title
                Watch for: $watchFor
                Genre: ${selectedGenres.joinToString(", ")}
                Year: $selectedYear
                Duration: $selectedHour Hour(s) $selectedMinute Minute(s)
            """.trimIndent()

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
