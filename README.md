# ViperAndroid
Viper framework for android

## Download
```gradle
repositories {
    maven {
        url 'https://dl.bintray.com/adef145/maven/'
    }
}

...

dependencies {
    compile 'com.adefruandta.viper:viper:0.3.0'
}
```

In this library the presenter & interactor implement the base lifecycle of Activity or Fragment. For more detail, see below.

## Contract

### ViperContract
* ViewBehavior

* Presenter
    * `unregister`. Called when view destroyed.
    
* Interactor
    * `unregister`. Called when view destroyed.
    * `setInteractorOutput`. Called when Interactor created and the output should implemented in presenter.

* InteractorOutput

* Router
    * `unregister`. Called when view destroyed.
    
### ViperActivityContract
* ViewBehavior extends ViperContract.ViewBehavior
    * `setTitle(title: String)`
    * `setTitle(titleResId: Int)`
    * `showToolbar`. Showing action bar.
    * `hideToolbar`. Hiding action bar.
    * `showBackButton`. Showing back button / home button.
    * `hideBackButton`. Hiding back button / home button.

* Presenter extends ViperContract.Presenter
    * `onCreate(extras: Bundle?, savedInstanceState: Bundle?)`. Called when presenter created.
    * `onPostCreate`. Called when the activity called `onPostCreate`.
    * `onStart`. Called when the activity called `onStart`.
    * `onResume`. Called when the activity called `onResume`.
    * `onStop`. Called when the activity called `onStop`.
    * `onActivityResult`. Called when the activity called `onActivityResult`.
    * `onSavedInstanceState`. Called when the activity called `onSavedInstanceState`.

* Interactor extends ViperContract.Interactor
    * `onCreate(extras: Bundle?, savedInstanceState: Bundle?)`. Called when interactor created.
    * `onPostCreate`. Called when the activity called `onPostCreate`.
    * `onStart`. Called when the activity called `onStart`.
    * `onResume`. Called when the activity called `onResume`.
    * `onStop`. Called when the activity called `onStop`.
    * `onActivityResult`. Called when the activity called `onActivityResult`.
    * `onSavedInstanceState`. Called when the activity called `onSavedInstanceState`.

* InteractorOutput extends ViperContract.InteractorOutput

### ViperDrawerActivityContract
* ViewBehavior extends ViperActivityContract.ViewBehavior
    * `closeDrawers`

* Presenter extends ViperActivityContract.Presenter

* Interactor extends ViperActivityContract.Interactor

* InteractorOutput extends ViperActivityContract.InteractorOutput

### ViperFragmentContract
* ViewBehavior extends ViperContract.ViewBehavior
    * `setTitle(title: String)`
    * `setTitle(titleResId: Int)`
    * `finishActivity`

* Presenter extends ViperContract.Presenter
    * `onCreate(extras: Bundle?, savedInstanceState: Bundle?)`. Called when presenter created.
    * `onViewCreated`. Called when fragment called `onViewCreated`.
    * `onStart`. Called when the fragment called `onStart`.
    * `onResume`. Called when the fragment called `onResume`.
    * `onStop`. Called when the fragment called `onStop`.
    * `onActivityResult`. Called when the fragment called `onActivityResult`.
    * `onSavedInstanceState`. Called when the fragment called `onSavedInstanceState`.

* Interactor extends ViperContract.Interactor
    * `onCreate(extras: Bundle?, savedInstanceState: Bundle?)`. Called when interactor created.
    * `onViewCreated`. Called when fragment called `onViewCreated`.
    * `onStart`. Called when the activity called `onStart`.
    * `onResume`. Called when the activity called `onResume`.
    * `onStop`. Called when the activity called `onStop`.
    * `onActivityResult`. Called when the activity called `onActivityResult`.
    * `onSavedInstanceState`. Called when the activity called `onSavedInstanceState`.

* InteractorOutput extends ViperContract.InteractorOutput
    * `finishActivity`
    
### ViperDialogFragmentContract
* ViewBehavior extends ViperFragmentContract.ViewBehavior
    * `dismiss`

* Presenter extends ViperFragmentContract.Presenter
    * `onCreateDialog`. Called when dialog fragment call `onCreateDialog`.

* Interactor extends ViperFragmentContract.Interactor

* InteractorOutput extends ViperContract.InteractorOutput
    * `dismiss`

## [Activity]

### ViperActivity
Basically, ViperActivity will inherit AppCompatActivity. Custom inherit in ViperActivity see below.

##### Inherit attributes
* open `contentResId: Int` default `R.id.container`. Require ViewGroup id.
* open `layoutResId: Int` default `R.layout.activity_base`. For `setContentView(layoutResId)`
* `fragment: ? extends Fragment` default `null`.
* `presenter: ? extends ViperActivityContract.Presenter` default `null`.
* `container: ViewGroup bindView(contentResId)`

##### Inherit functions
* `hasFragment: Boolean`. Check if already has fragment (because saved instance state) or not.
* open `onRestoreFragment: ? extends Fragment`. This function called if only `hasFragment == true`.
* open `onFragmentRestored(fragment: ? extends Fragment?)`. This function called if only `hasFragment == true` and after onRestoreFragment.
* open `onCreateFragment: ? extends Fragment?`. This function called if only `hasFragment == false`.
* open `onFragmentCreated(fragment: ? extends Fragment?)`. This function called if only `hasFragment == false` and after onCreateFragment.
* open `onCreatePresenter: ? extends ViperActivityContract.Presenter?`. Override this function if only have custom presenter.
* open `onPresenterCreated(presenter: ? extends ViperActivityContract.Presenter?)`. This function called after onCreatePresenter.

### ViperDrawerActivity extends ViperActivity

##### Inherit attributes
* `drawerToggle: ActionBarDrawerToggle`
* `drawerLayout: DrawerLayout by bindView(R.id.drawerLayout)`
* `navigationView: NavigationView by bindView(R.id.navigationView)`

##### Inherit functions
* `isDrawerOpen`. Check is drawer open or not.
* open `onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView)`. Override this function for custom the navigation view. Either inflate or set menu id.

## [Fragment]

### ViperFragment

##### Inherit attributes
* open `menuResId: Int`. The menu id will inflate.
* open `attachToRoot: Boolean`
* open `layoutResId: Int`. For decide which layout fragment will inflate.
* `presenter: ViperFragmentContract.Presenter`

##### Inherit functions
* `hasOptionsMenu`. True if menuResId not null.
* open `onCreatePresenter: ? extends ViperActivityContract.Presenter?`. Override this function if only have custom presenter.
* open `onPresenterCreated(presenter: ? extends ViperActivityContract.Presenter?)`. This function called after onCreatePresenter.

### ViperDialogFragment

##### Inherit attributes
* open `layoutResId: Int`. For decide which layout fragment will inflate.
* `presenter: ViperFragmentContract.Presenter`

##### Inherit functions
* open `onCreatePresenter: ? extends ViperActivityContract.Presenter?`. Override this function if only have custom presenter.
* open `onPresenterCreated(presenter: ? extends ViperActivityContract.Presenter?)`. This function called after onCreatePresenter.

## ViperRouter

##### Inherit functions
* `startActivity(intent: Intent)`
* `startActivity(intent: Intent, options: Bundle?)`
* `startActivity(intent: Intent, requestCode: Int)`

## MVP
* ViperPresenter implements ViperContract.Presenter
* ViperInteractor implements ViperContract.Interactor
* ViperRouter implements ViperContract.Router