package com.lantopia.libdroid;

import android.app.Activity;
import android.os.Bundle;

import com.lantopia.libjava.state.State;
import com.lantopia.libjava.state.States;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Mark McKenna %lt;mark.mckenna@teamspace.ca>
 * @version 0.1
 * @since 23/01/14
 *
 * An {@link android.app.Activity} instance that practises safe, two-phase initialization.
 */
public class SafeActivity extends Activity {
    public static final State New = States.stateBuilder().named("New").build();
    public static final State Initializing = States.stateBuilder().named("Initializing").build();
    public static final State Initialized = States.stateBuilder().named("Initialized").build();
    public static final State Destroyed = States.stateBuilder().named("Destroyed").build();

    private AtomicReference<State> state = new AtomicReference<>(New);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        if (!state.compareAndSet(New, Initializing)) {
        }

        super.onCreate(savedInstanceState);
    }

}
