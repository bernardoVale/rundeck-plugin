package org.jenkinsci.plugins.rundeck;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.workflow.steps.AbstractSynchronousNonBlockingStepExecution;
import org.jenkinsci.plugins.workflow.steps.StepContextParameter;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.inject.Inject;

public class RundeckStepExecutor extends AbstractSynchronousNonBlockingStepExecution<Void> {

    @Inject
    private transient RundeckStep step;

    @StepContextParameter
    private transient TaskListener listener;

    @StepContextParameter
    private transient FilePath ws;

    @StepContextParameter
    private transient Run build;

    @StepContextParameter
    private transient Launcher launcher;


    @Override
    protected Void run() throws Exception {
        listener.getLogger().println("Running Rundeck run job step.");
        RundeckNotifier notifier = new RundeckNotifier(
                null, step.getJobId(), null, null, null,
                true, true, null, null,
                "4omJhZ690koBRIvEagiMRwBKGlSorNwk"
        );
        notifier.perform(build, ws, launcher, listener);
        return null;
    }

    private static final long serialVersionUID = 1L;
}
