package org.jenkinsci.plugins.rundeck;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

public class RundeckStep extends AbstractStepImpl {

    private final String jobId;

    @DataBoundConstructor
    public RundeckStep(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    @Extension
    public static class DescriptorImpl extends AbstractStepDescriptorImpl {
        public DescriptorImpl() { super(RundeckStepExecutor.class); }

        @Override
        public String getFunctionName() {
            return "rundeck";
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return "Run a Rundeck job";
        }
    }
}
