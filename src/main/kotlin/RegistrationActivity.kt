import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var schoolEditText: EditText
    private lateinit var gradeSpinner: Spinner
    private lateinit var ageEditText: EditText
    private lateinit var genderSpinner: Spinner
    private lateinit var countrySpinner: Spinner
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        schoolEditText = findViewById(R.id.school)
        gradeSpinner = findViewById(R.id.grade_spinner)
        ageEditText = findViewById(R.id.age)
        genderSpinner = findViewById(R.id.gender_spinner)
        countrySpinner = findViewById(R.id.country_spinner)
        registerButton = findViewById(R.id.register_button)

        setupSpinners()
        
        registerButton.setOnClickListener {
            registerUser()
        }
    }

    private fun setupSpinners() {
        // Set up grade spinner
        val grades = arrayOf("Grade 3 to 6", "Grade 7 to 9", "Grade 10 to 12")
        gradeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, grades)

        // Set up gender spinner
        val genders = arrayOf("Male", "Female", "Other")
        genderSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)

        // Set up country spinner (default to Papua New Guinea)
        val countries = arrayOf("Papua New Guinea", "Australia", "USA") // Add more as needed
        countrySpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
    }

    private fun registerUser() {
        // Get data from input fields
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val school = schoolEditText.text.toString()
        val grade = gradeSpinner.selectedItem.toString()
        val age = ageEditText.text.toString()
        val gender = genderSpinner.selectedItem.toString()
        val country = countrySpinner.selectedItem.toString()

        // Here you would typically send the data to your backend for registration

        // For now, you can display a message or handle UI updates
        // e.g., show a Toast message or navigate to another activity
    }
}
