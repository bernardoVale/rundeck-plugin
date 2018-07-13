package org.jenkinsci.plugins.rundeck;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

public class RundeckStep extends AbstractStepImpl {

    private String rundeckInstanceName;

    private final String jobId;

    private final String options;

    private final String nodeFilters;

    private transient final String tag;

    private String[] tags;

    private final Boolean shouldWaitForRundeckJob;

    private final Boolean shouldFailTheBuild;

    private final Boolean includeRundeckLogs;

    private final Boolean tailLog;

    /** for multiple rundeck users */
    private String jobUser;
    private String jobPassword;
    private String jobToken;

    @DataBoundConstructor
    public RundeckStep(String rundeckInstanceName, String jobId, String options, String nodeFilters,
                       String tag, String[] tags,
                       Boolean shouldWaitForRundeckJob, Boolean shouldFailTheBuild,
                       Boolean includeRundeckLogs, Boolean tailLog, String jobUser,
                       String jobPassword, String jobToken) {
        this.jobId = jobId;
        this.options = options;
        this.nodeFilters = nodeFilters;
        this.tag = tag;
        this.tags = tags;
        this.shouldWaitForRundeckJob = shouldWaitForRundeckJob;
        this.shouldFailTheBuild = shouldFailTheBuild;
        this.includeRundeckLogs = includeRundeckLogs;
        this.tailLog = tailLog;
        this.jobUser = jobUser;
        this.jobPassword = jobPassword;
        this.jobToken = jobToken;
    }

    public String getRundeckInstanceName() {
        return rundeckInstanceName;
    }

    public String getOptions() {
        return options;
    }

    public String getNodeFilters() {
        return nodeFilters;
    }

    public String getTag() {
        return tag;
    }

    public String[] getTags() {
        return tags;
    }

    public Boolean getShouldWaitForRundeckJob() {
        return shouldWaitForRundeckJob;
    }

    public Boolean getShouldFailTheBuild() {
        return shouldFailTheBuild;
    }

    public Boolean getIncludeRundeckLogs() {
        return includeRundeckLogs;
    }

    public Boolean getTailLog() {
        return tailLog;
    }

    public String getJobUser() {
        return jobUser;
    }

    public String getJobPassword() {
        return jobPassword;
    }

    public String getJobToken() {
        return jobToken;
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
