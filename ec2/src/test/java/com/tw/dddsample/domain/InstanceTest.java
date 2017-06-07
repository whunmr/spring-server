package com.tw.dddsample.domain;


import com.tw.dddsample.domain.instance.Instance;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by azhu on 25/05/2017.
 */
public class InstanceTest {


    @Test
    public void should_be_active_automatically_after_it_is_created() {
        Instance instance = createAnInstance();
        boolean isLaunched = instance.launch();

        assertThat(isLaunched, is(true));
        assertThat(instance.status(), is(Instance.VMStatus.Pending));
    }


    @Test
    public void should_not_be_launch_except_initial_instance() {
        Instance runningInstance = createRunningInstance();

        boolean isLaunched = runningInstance.launch();

        assertThat(isLaunched, is(false));
    }

    @Test
    public void should_be_running_automatically_after_finish_launch() {
        Instance instance = createAnInstance();
        instance.launch();

        instance.moveStatusTo(Instance.VMStatus.Running);

        assertThat(instance.status(), is(Instance.VMStatus.Running));
    }

    @Test
    public void should_not_be_running_automatically_before_launch() {
        Instance anInstance = createAnInstance();

        boolean isAutoActived = anInstance.moveStatusTo(Instance.VMStatus.Running);

        assertThat(isAutoActived, is(false));
    }


    @Test
    public void should_reboot_instance_after_reboot_when_it_is_running() {
        Instance runningInstance = createRunningInstance();

        boolean isRebooting = runningInstance.reboot();

        assertThat(isRebooting, is(true));
    }

    @Test
    public void should_not_reboot_instance_when_it_is_not_running() {
        Instance instanceNotRunning = createAnInstance();

        boolean isRebooting = instanceNotRunning.reboot();

        assertThat(isRebooting, is(false));
    }


    @Test
    public void should_be_running_automatically_after_finish_rebooting() {
        Instance runningInstance = createRunningInstance();
        runningInstance.reboot();
        Instance rebootingInstance = runningInstance;

        boolean isAutoRunning = rebootingInstance.moveStatusTo(Instance.VMStatus.Running);

        assertThat(isAutoRunning, is(true));
        assertThat(rebootingInstance.status(), is(Instance.VMStatus.Running));
    }

    @Test
    public void should_be_shutting_down_when_terminate() {
        Instance runningInstance = createRunningInstance();

        boolean isTerminated = runningInstance.terminate();

        assertThat(isTerminated, is(true));
        assertThat(runningInstance.status(), is(Instance.VMStatus.ShuttingDown));
    }

    @Test
    public void should_be_terminate_automatically_after_finish_shut_down() {
        Instance runningInstance = createRunningInstance();
        runningInstance.terminate();
        Instance shuttingDownInstance = runningInstance;

        boolean isTerminated = shuttingDownInstance.moveStatusTo(Instance.VMStatus.Terminated);
        assertThat(isTerminated, is(true));
        assertThat(shuttingDownInstance.status(), is(Instance.VMStatus.Terminated));
    }

    private Instance createAnInstance() {
        return new Instance();
    }

    private Instance createRunningInstance() {
        Instance instance = createAnInstance();
        instance.launch();
        instance.moveStatusTo(Instance.VMStatus.Running);
        return instance;
    }



}