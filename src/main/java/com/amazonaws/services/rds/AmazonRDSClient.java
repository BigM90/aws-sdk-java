/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.rds;

import org.w3c.dom.*;

import java.util.*;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.rds.model.*;
import com.amazonaws.services.rds.model.transform.*;


/**
 * Client for accessing AmazonRDS.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon Relational Database Service <p>
 * Amazon Relational Database Service (Amazon RDS) is a web service that makes it easier to set up, operate, and scale a relational database in the
 * cloud. It provides cost-efficient, resizable capacity for an industry-standard relational database and manages common database administration tasks,
 * freeing up developers to focus on what makes their applications and businesses unique.
 * </p>
 * <p>
 * Amazon RDS gives you access to the capabilities of a familiar MySQL or Oracle database server. This means the code, applications, and tools you
 * already use today with your existing MySQL or Oracle databases work with Amazon RDS without modification. Amazon RDS automatically backs up your
 * database and maintains the database software that powers your DB Instance. Amazon RDS is flexible: you can scale your database instance's compute
 * resources and storage capacity to meet your application's demand. As with all Amazon Web Services, there are no up-front investments, and you pay only
 * for the resources you use.
 * </p>
 * <p>
 * This is the <i>Amazon RDS API Reference</i> . It contains a comprehensive description of all Amazon RDS Query APIs and data types. Note that this API
 * is asynchronous and some actions may require polling to determine when an action has been applied. See the parameter description to determine if a
 * change is applied immediately or on the next instance reboot or during the maintenance window. For more information on Amazon RDS concepts and usage
 * scenarios, go to the <a href="http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/"> Amazon RDS User Guide </a> .
 * </p>
 */
public class AmazonRDSClient extends AmazonWebServiceClient implements AmazonRDS {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonRDS exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    
    /** AWS signer for authenticating requests. */
    private AWS4Signer signer;


    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRDSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRDS
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRDSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonRDSClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRDS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRDSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonRDSClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRDS using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRDS
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRDSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new DBParameterGroupNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBParameterGroupQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new AuthorizationNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new OptionGroupQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SourceNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ReservedDBInstanceAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSubnetGroupDoesNotCoverEnoughAZsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ProvisionedIopsNotAvailableInAZExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBSnapshotStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSnapshotNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSecurityGroupAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PointInTimeRestoreNotEnabledExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBSubnetStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new StorageQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidVPCNetworkStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidOptionGroupStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSecurityGroupQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidRestoreExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ReservedDBInstancesOfferingNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBSubnetGroupStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new AuthorizationAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBUpgradeDependencyFailureExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBInstanceNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SNSTopicArnNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InstanceQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SubscriptionCategoryNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SNSInvalidTopicExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ReservedDBInstanceQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidEventSubscriptionStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBSecurityGroupStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSnapshotAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InsufficientDBInstanceCapacityExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SubscriptionNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBInstanceAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSubnetGroupAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SubscriptionAlreadyExistExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SubnetAlreadyInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSubnetGroupQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ReservedDBInstanceNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSecurityGroupNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SNSNoAuthorizationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new OptionGroupAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new AuthorizationQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new OptionGroupNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSubnetGroupNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBParameterGroupStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidSubnetExceptionUnmarshaller());
        exceptionUnmarshallers.add(new SnapshotQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBParameterGroupAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSubnetQuotaExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDBInstanceStateExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DBSecurityGroupNotSupportedExceptionUnmarshaller());
        exceptionUnmarshallers.add(new EventSubscriptionQuotaExceededExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("rds.amazonaws.com");

        signer = new AWS4Signer();
        
        signer.setServiceName("rds");
        

        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandlers.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/rds/request.handlers"));
    }

    
    /**
     * <p>
     * Returns information about reserved DB Instances for this account, or
     * about a specified reserved DB Instance.
     * </p>
     *
     * @param describeReservedDBInstancesRequest Container for the necessary
     *           parameters to execute the DescribeReservedDBInstances service method
     *           on AmazonRDS.
     * 
     * @return The response from the DescribeReservedDBInstances service
     *         method, as returned by AmazonRDS.
     * 
     * @throws ReservedDBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedDBInstancesResult describeReservedDBInstances(DescribeReservedDBInstancesRequest describeReservedDBInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedDBInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedDBInstancesRequest> request = null;
        DescribeReservedDBInstancesResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedDBInstancesRequestMarshaller().marshall(describeReservedDBInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeReservedDBInstancesResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Removes a source identifier from an existing RDS event notification
     * subscription.
     * </p>
     *
     * @param removeSourceIdentifierFromSubscriptionRequest Container for the
     *           necessary parameters to execute the
     *           RemoveSourceIdentifierFromSubscription service method on AmazonRDS.
     * 
     * @return The response from the RemoveSourceIdentifierFromSubscription
     *         service method, as returned by AmazonRDS.
     * 
     * @throws SourceNotFoundException
     * @throws SubscriptionNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EventSubscription removeSourceIdentifierFromSubscription(RemoveSourceIdentifierFromSubscriptionRequest removeSourceIdentifierFromSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(removeSourceIdentifierFromSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RemoveSourceIdentifierFromSubscriptionRequest> request = null;
        EventSubscription response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RemoveSourceIdentifierFromSubscriptionRequestMarshaller().marshall(removeSourceIdentifierFromSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EventSubscriptionStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a DBSnapshot.
     * </p>
     * <p>
     * <b>NOTE:</b>The DBSnapshot must be in the available state to be
     * deleted.
     * </p>
     *
     * @param deleteDBSnapshotRequest Container for the necessary parameters
     *           to execute the DeleteDBSnapshot service method on AmazonRDS.
     * 
     * @return The response from the DeleteDBSnapshot service method, as
     *         returned by AmazonRDS.
     * 
     * @throws InvalidDBSnapshotStateException
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSnapshot deleteDBSnapshot(DeleteDBSnapshotRequest deleteDBSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDBSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDBSnapshotRequest> request = null;
        DBSnapshot response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteDBSnapshotRequestMarshaller().marshall(deleteDBSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSnapshotStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new DB Instance from a DB snapshot. The target database is
     * created from the source database restore point with the same
     * configuration as the original source database, except that the new RDS
     * instance is created with the default security group.
     * </p>
     *
     * @param restoreDBInstanceFromDBSnapshotRequest Container for the
     *           necessary parameters to execute the RestoreDBInstanceFromDBSnapshot
     *           service method on AmazonRDS.
     * 
     * @return The response from the RestoreDBInstanceFromDBSnapshot service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBSubnetGroupNotFoundException
     * @throws DBInstanceAlreadyExistsException
     * @throws InvalidVPCNetworkStateException
     * @throws InvalidDBSnapshotStateException
     * @throws InvalidSubnetException
     * @throws DBSnapshotNotFoundException
     * @throws InvalidRestoreException
     * @throws InstanceQuotaExceededException
     * @throws StorageQuotaExceededException
     * @throws InsufficientDBInstanceCapacityException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws OptionGroupNotFoundException
     * @throws ProvisionedIopsNotAvailableInAZException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance restoreDBInstanceFromDBSnapshot(RestoreDBInstanceFromDBSnapshotRequest restoreDBInstanceFromDBSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(restoreDBInstanceFromDBSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RestoreDBInstanceFromDBSnapshotRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RestoreDBInstanceFromDBSnapshotRequestMarshaller().marshall(restoreDBInstanceFromDBSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Displays a list of categories for all event source types, or, if
     * specified, for a specified source type. You can see a list of the
     * event categories and source types in the <a
     * tp://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Events.html">
     * Events </a> topic in the Amazon RDS User Guide.
     * </p>
     *
     * @param describeEventCategoriesRequest Container for the necessary
     *           parameters to execute the DescribeEventCategories service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeEventCategories service method,
     *         as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventCategoriesResult describeEventCategories(DescribeEventCategoriesRequest describeEventCategoriesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeEventCategoriesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeEventCategoriesRequest> request = null;
        DescribeEventCategoriesResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeEventCategoriesRequestMarshaller().marshall(describeEventCategoriesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeEventCategoriesResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Enables ingress to a DBSecurityGroup using one of two forms of
     * authorization. First, EC2 or VPC Security Groups can be added to the
     * DBSecurityGroup if the application using the database is running on
     * EC2 or VPC instances. Second, IP ranges are available if the
     * application accessing your database is running on the Internet.
     * Required parameters for this API are one of CIDR range,
     * EC2SecurityGroupId for VPC, or (EC2SecurityGroupOwnerId and either
     * EC2SecurityGroupName or EC2SecurityGroupId for non-VPC).
     * </p>
     * <p>
     * <b>NOTE:</b> You cannot authorize ingress from an EC2 security group
     * in one Region to an Amazon RDS DB Instance in another. You cannot
     * authorize ingress from a VPC security group in one VPC to an Amazon
     * RDS DB Instance in another.
     * </p>
     * <p>
     * For an overview of CIDR ranges, go to the <a
     * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
     * Wikipedia Tutorial </a> .
     * </p>
     *
     * @param authorizeDBSecurityGroupIngressRequest Container for the
     *           necessary parameters to execute the AuthorizeDBSecurityGroupIngress
     *           service method on AmazonRDS.
     * 
     * @return The response from the AuthorizeDBSecurityGroupIngress service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBSecurityGroupNotFoundException
     * @throws InvalidDBSecurityGroupStateException
     * @throws AuthorizationAlreadyExistsException
     * @throws AuthorizationQuotaExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSecurityGroup authorizeDBSecurityGroupIngress(AuthorizeDBSecurityGroupIngressRequest authorizeDBSecurityGroupIngressRequest) {
        ExecutionContext executionContext = createExecutionContext(authorizeDBSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AuthorizeDBSecurityGroupIngressRequest> request = null;
        DBSecurityGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AuthorizeDBSecurityGroupIngressRequestMarshaller().marshall(authorizeDBSecurityGroupIngressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSecurityGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates an RDS event notification subscription. This action requires a
     * topic ARN (Amazon Resource Name) created by either the RDS console,
     * the SNS console, or the SNS API. To obtain an ARN with SNS, you must
     * create a topic in Amazon SNS and subscribe to the topic. The ARN is
     * displayed in the SNS console.
     * </p>
     * <p>
     * You can specify the type of source (SourceType) you want to be
     * notified of, provide a list of RDS sources (SourceIds) that triggers
     * the events, and provide a list of event categories (EventCategories)
     * for events you want to be notified of. For example, you can specify
     * SourceType = db-instance, SourceIds = mydbinstance1, mydbinstance2 and
     * EventCategories = Availability, Backup.
     * </p>
     * <p>
     * If you specify both the SourceType and SourceIds, such as SourceType =
     * db-instance and SourceIdentifier = myDBInstance1, you will be notified
     * of all the db-instance events for the specified source. If you specify
     * a SourceType but do not specify a SourceIdentifier, you will receive
     * notice of the events for that source type for all your RDS sources. If
     * you do not specify either the SourceType nor the SourceIdentifier, you
     * will be notified of events generated from all RDS sources belonging to
     * your customer account.
     * </p>
     *
     * @param createEventSubscriptionRequest Container for the necessary
     *           parameters to execute the CreateEventSubscription service method on
     *           AmazonRDS.
     * 
     * @return The response from the CreateEventSubscription service method,
     *         as returned by AmazonRDS.
     * 
     * @throws SourceNotFoundException
     * @throws SNSTopicArnNotFoundException
     * @throws SNSInvalidTopicException
     * @throws SubscriptionCategoryNotFoundException
     * @throws SNSNoAuthorizationException
     * @throws EventSubscriptionQuotaExceededException
     * @throws SubscriptionAlreadyExistException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EventSubscription createEventSubscription(CreateEventSubscriptionRequest createEventSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(createEventSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateEventSubscriptionRequest> request = null;
        EventSubscription response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateEventSubscriptionRequestMarshaller().marshall(createEventSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EventSubscriptionStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Modifies an existing Option Group.
     * </p>
     *
     * @param modifyOptionGroupRequest Container for the necessary parameters
     *           to execute the ModifyOptionGroup service method on AmazonRDS.
     * 
     * @return The response from the ModifyOptionGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws InvalidOptionGroupStateException
     * @throws OptionGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public OptionGroup modifyOptionGroup(ModifyOptionGroupRequest modifyOptionGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyOptionGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyOptionGroupRequest> request = null;
        OptionGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyOptionGroupRequestMarshaller().marshall(modifyOptionGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new OptionGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Modifies the parameters of a DBParameterGroup to the engine/system
     * default value. To reset specific parameters submit a list of the
     * following: ParameterName and ApplyMethod. To reset the entire
     * DBParameterGroup specify the DBParameterGroup name and
     * ResetAllParameters parameters. When resetting the entire group,
     * dynamic parameters are updated immediately and static parameters are
     * set to pending-reboot to take effect on the next DB instance restart
     * or RebootDBInstance request.
     * </p>
     *
     * @param resetDBParameterGroupRequest Container for the necessary
     *           parameters to execute the ResetDBParameterGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the ResetDBParameterGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws InvalidDBParameterGroupStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ResetDBParameterGroupResult resetDBParameterGroup(ResetDBParameterGroupRequest resetDBParameterGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(resetDBParameterGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ResetDBParameterGroupRequest> request = null;
        ResetDBParameterGroupResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ResetDBParameterGroupRequestMarshaller().marshall(resetDBParameterGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new ResetDBParameterGroupResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns the default engine and system parameter information for the
     * specified database engine.
     * </p>
     *
     * @param describeEngineDefaultParametersRequest Container for the
     *           necessary parameters to execute the DescribeEngineDefaultParameters
     *           service method on AmazonRDS.
     * 
     * @return The response from the DescribeEngineDefaultParameters service
     *         method, as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EngineDefaults describeEngineDefaultParameters(DescribeEngineDefaultParametersRequest describeEngineDefaultParametersRequest) {
        ExecutionContext executionContext = createExecutionContext(describeEngineDefaultParametersRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeEngineDefaultParametersRequest> request = null;
        EngineDefaults response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeEngineDefaultParametersRequestMarshaller().marshall(describeEngineDefaultParametersRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EngineDefaultsStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Lists available reserved DB Instance offerings.
     * </p>
     *
     * @param describeReservedDBInstancesOfferingsRequest Container for the
     *           necessary parameters to execute the
     *           DescribeReservedDBInstancesOfferings service method on AmazonRDS.
     * 
     * @return The response from the DescribeReservedDBInstancesOfferings
     *         service method, as returned by AmazonRDS.
     * 
     * @throws ReservedDBInstancesOfferingNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings(DescribeReservedDBInstancesOfferingsRequest describeReservedDBInstancesOfferingsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedDBInstancesOfferingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedDBInstancesOfferingsRequest> request = null;
        DescribeReservedDBInstancesOfferingsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedDBInstancesOfferingsRequestMarshaller().marshall(describeReservedDBInstancesOfferingsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeReservedDBInstancesOfferingsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a DB subnet group.
     * </p>
     * <p>
     * <b>NOTE:</b>The specified database subnet group must not be associated
     * with any DB instances.
     * </p>
     *
     * @param deleteDBSubnetGroupRequest Container for the necessary
     *           parameters to execute the DeleteDBSubnetGroup service method on
     *           AmazonRDS.
     * 
     * @throws DBSubnetGroupNotFoundException
     * @throws InvalidDBSubnetGroupStateException
     * @throws InvalidDBSubnetStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteDBSubnetGroup(DeleteDBSubnetGroupRequest deleteDBSubnetGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDBSubnetGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDBSubnetGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteDBSubnetGroupRequestMarshaller().marshall(deleteDBSubnetGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns information about provisioned RDS instances. This API
     * supports pagination.
     * </p>
     *
     * @param describeDBInstancesRequest Container for the necessary
     *           parameters to execute the DescribeDBInstances service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBInstances service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBInstancesResult describeDBInstances(DescribeDBInstancesRequest describeDBInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBInstancesRequest> request = null;
        DescribeDBInstancesResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBInstancesRequestMarshaller().marshall(describeDBInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBInstancesResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of the available DB engines.
     * </p>
     *
     * @param describeDBEngineVersionsRequest Container for the necessary
     *           parameters to execute the DescribeDBEngineVersions service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBEngineVersions service method,
     *         as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBEngineVersionsResult describeDBEngineVersions(DescribeDBEngineVersionsRequest describeDBEngineVersionsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBEngineVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBEngineVersionsRequest> request = null;
        DescribeDBEngineVersionsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBEngineVersionsRequestMarshaller().marshall(describeDBEngineVersionsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBEngineVersionsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Promotes a Read Replica DB Instance to a standalone DB Instance.
     * </p>
     *
     * @param promoteReadReplicaRequest Container for the necessary
     *           parameters to execute the PromoteReadReplica service method on
     *           AmazonRDS.
     * 
     * @return The response from the PromoteReadReplica service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws InvalidDBInstanceStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance promoteReadReplica(PromoteReadReplicaRequest promoteReadReplicaRequest) {
        ExecutionContext executionContext = createExecutionContext(promoteReadReplicaRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<PromoteReadReplicaRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new PromoteReadReplicaRequestMarshaller().marshall(promoteReadReplicaRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a specified DBParameterGroup. The DBParameterGroup cannot be
     * associated with any RDS instances to be deleted.
     * </p>
     * <p>
     * <b>NOTE:</b> The specified DB Parameter Group cannot be associated
     * with any DB Instances.
     * </p>
     *
     * @param deleteDBParameterGroupRequest Container for the necessary
     *           parameters to execute the DeleteDBParameterGroup service method on
     *           AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws InvalidDBParameterGroupStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteDBParameterGroup(DeleteDBParameterGroupRequest deleteDBParameterGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDBParameterGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDBParameterGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteDBParameterGroupRequestMarshaller().marshall(deleteDBParameterGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns information about DBSnapshots. This API supports pagination.
     * </p>
     *
     * @param describeDBSnapshotsRequest Container for the necessary
     *           parameters to execute the DescribeDBSnapshots service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBSnapshots service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSnapshotsResult describeDBSnapshots(DescribeDBSnapshotsRequest describeDBSnapshotsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBSnapshotsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBSnapshotsRequest> request = null;
        DescribeDBSnapshotsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBSnapshotsRequestMarshaller().marshall(describeDBSnapshotsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBSnapshotsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of DBSubnetGroup descriptions. If a DBSubnetGroupName
     * is specified, the list will contain only the descriptions of the
     * specified DBSubnetGroup.
     * </p>
     * <p>
     * For an overview of CIDR ranges, go to the <a
     * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
     * Wikipedia Tutorial </a> .
     * </p>
     *
     * @param describeDBSubnetGroupsRequest Container for the necessary
     *           parameters to execute the DescribeDBSubnetGroups service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBSubnetGroups service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBSubnetGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSubnetGroupsResult describeDBSubnetGroups(DescribeDBSubnetGroupsRequest describeDBSubnetGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBSubnetGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBSubnetGroupsRequest> request = null;
        DescribeDBSubnetGroupsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBSubnetGroupsRequestMarshaller().marshall(describeDBSubnetGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBSubnetGroupsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Restores a DB Instance to an arbitrary point-in-time. Users can
     * restore to any point in time before the latestRestorableTime for up to
     * backupRetentionPeriod days. The target database is created from the
     * source database with the same configuration as the original database
     * except that the DB instance is created with the default DB security
     * group.
     * </p>
     *
     * @param restoreDBInstanceToPointInTimeRequest Container for the
     *           necessary parameters to execute the RestoreDBInstanceToPointInTime
     *           service method on AmazonRDS.
     * 
     * @return The response from the RestoreDBInstanceToPointInTime service
     *         method, as returned by AmazonRDS.
     * 
     * @throws PointInTimeRestoreNotEnabledException
     * @throws DBSubnetGroupNotFoundException
     * @throws DBInstanceAlreadyExistsException
     * @throws DBInstanceNotFoundException
     * @throws InvalidVPCNetworkStateException
     * @throws InvalidSubnetException
     * @throws InvalidRestoreException
     * @throws InstanceQuotaExceededException
     * @throws StorageQuotaExceededException
     * @throws InvalidDBInstanceStateException
     * @throws InsufficientDBInstanceCapacityException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws OptionGroupNotFoundException
     * @throws ProvisionedIopsNotAvailableInAZException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance restoreDBInstanceToPointInTime(RestoreDBInstanceToPointInTimeRequest restoreDBInstanceToPointInTimeRequest) {
        ExecutionContext executionContext = createExecutionContext(restoreDBInstanceToPointInTimeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RestoreDBInstanceToPointInTimeRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RestoreDBInstanceToPointInTimeRequestMarshaller().marshall(restoreDBInstanceToPointInTimeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of orderable DB Instance options for the specified
     * engine.
     * </p>
     *
     * @param describeOrderableDBInstanceOptionsRequest Container for the
     *           necessary parameters to execute the DescribeOrderableDBInstanceOptions
     *           service method on AmazonRDS.
     * 
     * @return The response from the DescribeOrderableDBInstanceOptions
     *         service method, as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeOrderableDBInstanceOptionsResult describeOrderableDBInstanceOptions(DescribeOrderableDBInstanceOptionsRequest describeOrderableDBInstanceOptionsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeOrderableDBInstanceOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeOrderableDBInstanceOptionsRequest> request = null;
        DescribeOrderableDBInstanceOptionsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeOrderableDBInstanceOptionsRequestMarshaller().marshall(describeOrderableDBInstanceOptionsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeOrderableDBInstanceOptionsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Adds metadata tags to a DB Instance. These tags can also be used with
     * cost allocation reporting to track cost associated with a DB Instance.
     * </p>
     * <p>
     * For an overview on tagging DB Instances, see <a
     * docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Tagging.html">
     * DB Instance Tags. </a>
     * </p>
     *
     * @param addTagsToResourceRequest Container for the necessary parameters
     *           to execute the AddTagsToResource service method on AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void addTagsToResource(AddTagsToResourceRequest addTagsToResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(addTagsToResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AddTagsToResourceRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AddTagsToResourceRequestMarshaller().marshall(addTagsToResourceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Creates a DBSnapshot. The source DBInstance must be in "available"
     * state.
     * </p>
     *
     * @param createDBSnapshotRequest Container for the necessary parameters
     *           to execute the CreateDBSnapshot service method on AmazonRDS.
     * 
     * @return The response from the CreateDBSnapshot service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws InvalidDBInstanceStateException
     * @throws SnapshotQuotaExceededException
     * @throws DBSnapshotAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSnapshot createDBSnapshot(CreateDBSnapshotRequest createDBSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBSnapshotRequest> request = null;
        DBSnapshot response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBSnapshotRequestMarshaller().marshall(createDBSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSnapshotStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a DB Instance that acts as a Read Replica of a source DB
     * Instance.
     * </p>
     * <p>
     * All Read Replica DB Instances are created as Single-AZ deployments
     * with backups disabled. All other DB Instance attributes (including DB
     * Security Groups and DB Parameter Groups) are inherited from the source
     * DB Instance, except as specified below.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> The source DB Instance must have backup retention
     * enabled.
     * </p>
     *
     * @param createDBInstanceReadReplicaRequest Container for the necessary
     *           parameters to execute the CreateDBInstanceReadReplica service method
     *           on AmazonRDS.
     * 
     * @return The response from the CreateDBInstanceReadReplica service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws DBSubnetGroupNotFoundException
     * @throws DBInstanceAlreadyExistsException
     * @throws DBInstanceNotFoundException
     * @throws InvalidVPCNetworkStateException
     * @throws DBSecurityGroupNotFoundException
     * @throws InvalidSubnetException
     * @throws InstanceQuotaExceededException
     * @throws StorageQuotaExceededException
     * @throws InvalidDBInstanceStateException
     * @throws InsufficientDBInstanceCapacityException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws OptionGroupNotFoundException
     * @throws ProvisionedIopsNotAvailableInAZException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance createDBInstanceReadReplica(CreateDBInstanceReadReplicaRequest createDBInstanceReadReplicaRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBInstanceReadReplicaRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBInstanceReadReplicaRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBInstanceReadReplicaRequestMarshaller().marshall(createDBInstanceReadReplicaRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes all available options.
     * </p>
     *
     * @param describeOptionGroupOptionsRequest Container for the necessary
     *           parameters to execute the DescribeOptionGroupOptions service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeOptionGroupOptions service
     *         method, as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeOptionGroupOptionsResult describeOptionGroupOptions(DescribeOptionGroupOptionsRequest describeOptionGroupOptionsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeOptionGroupOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeOptionGroupOptionsRequest> request = null;
        DescribeOptionGroupOptionsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeOptionGroupOptionsRequestMarshaller().marshall(describeOptionGroupOptionsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeOptionGroupOptionsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Lists all the subscription descriptions for a customer account. The
     * description for a subscription includes SubscriptionName, SNSTopicARN,
     * CustomerID, SourceType, SourceID, CreationTime, and Status.
     * </p>
     * <p>
     * If you specify a SubscriptionName, lists the description for that
     * subscription.
     * </p>
     *
     * @param describeEventSubscriptionsRequest Container for the necessary
     *           parameters to execute the DescribeEventSubscriptions service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeEventSubscriptions service
     *         method, as returned by AmazonRDS.
     * 
     * @throws SubscriptionNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventSubscriptionsResult describeEventSubscriptions(DescribeEventSubscriptionsRequest describeEventSubscriptionsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeEventSubscriptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeEventSubscriptionsRequest> request = null;
        DescribeEventSubscriptionsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeEventSubscriptionsRequestMarshaller().marshall(describeEventSubscriptionsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeEventSubscriptionsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Modifies an existing DB subnet group. DB subnet groups must contain
     * at least one subnet in at least two AZs in the region.
     * </p>
     *
     * @param modifyDBSubnetGroupRequest Container for the necessary
     *           parameters to execute the ModifyDBSubnetGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the ModifyDBSubnetGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBSubnetGroupNotFoundException
     * @throws DBSubnetQuotaExceededException
     * @throws SubnetAlreadyInUseException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws InvalidSubnetException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSubnetGroup modifyDBSubnetGroup(ModifyDBSubnetGroupRequest modifyDBSubnetGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyDBSubnetGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyDBSubnetGroupRequest> request = null;
        DBSubnetGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyDBSubnetGroupRequestMarshaller().marshall(modifyDBSubnetGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSubnetGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new DB instance.
     * </p>
     *
     * @param createDBInstanceRequest Container for the necessary parameters
     *           to execute the CreateDBInstance service method on AmazonRDS.
     * 
     * @return The response from the CreateDBInstance service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws InstanceQuotaExceededException
     * @throws DBSubnetGroupNotFoundException
     * @throws DBInstanceAlreadyExistsException
     * @throws StorageQuotaExceededException
     * @throws InvalidVPCNetworkStateException
     * @throws DBSecurityGroupNotFoundException
     * @throws InsufficientDBInstanceCapacityException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws InvalidSubnetException
     * @throws OptionGroupNotFoundException
     * @throws ProvisionedIopsNotAvailableInAZException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance createDBInstance(CreateDBInstanceRequest createDBInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBInstanceRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBInstanceRequestMarshaller().marshall(createDBInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns the detailed parameter list for a particular
     * DBParameterGroup.
     * </p>
     *
     * @param describeDBParametersRequest Container for the necessary
     *           parameters to execute the DescribeDBParameters service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBParameters service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBParametersResult describeDBParameters(DescribeDBParametersRequest describeDBParametersRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBParametersRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBParametersRequest> request = null;
        DescribeDBParametersResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBParametersRequestMarshaller().marshall(describeDBParametersRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBParametersResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Copies the specified DBSnapshot. The source DBSnapshot must be in the
     * "available" state.
     * </p>
     *
     * @param copyDBSnapshotRequest Container for the necessary parameters to
     *           execute the CopyDBSnapshot service method on AmazonRDS.
     * 
     * @return The response from the CopyDBSnapshot service method, as
     *         returned by AmazonRDS.
     * 
     * @throws InvalidDBSnapshotStateException
     * @throws SnapshotQuotaExceededException
     * @throws DBSnapshotAlreadyExistsException
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSnapshot copyDBSnapshot(CopyDBSnapshotRequest copyDBSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(copyDBSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CopyDBSnapshotRequest> request = null;
        DBSnapshot response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CopyDBSnapshotRequestMarshaller().marshall(copyDBSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSnapshotStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new DB Security Group. DB Security Groups control access to
     * a DB Instance.
     * </p>
     *
     * @param createDBSecurityGroupRequest Container for the necessary
     *           parameters to execute the CreateDBSecurityGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the CreateDBSecurityGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBSecurityGroupQuotaExceededException
     * @throws DBSecurityGroupNotSupportedException
     * @throws DBSecurityGroupAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSecurityGroup createDBSecurityGroup(CreateDBSecurityGroupRequest createDBSecurityGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBSecurityGroupRequest> request = null;
        DBSecurityGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBSecurityGroupRequestMarshaller().marshall(createDBSecurityGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSecurityGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Lists all tags on a DB Instance.
     * </p>
     * <p>
     * For an overview on tagging DB Instances, see <a
     * docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Tagging.html">
     * DB Instance Tags. </a>
     * </p>
     *
     * @param listTagsForResourceRequest Container for the necessary
     *           parameters to execute the ListTagsForResource service method on
     *           AmazonRDS.
     * 
     * @return The response from the ListTagsForResource service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ListTagsForResourceRequest> request = null;
        ListTagsForResourceResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ListTagsForResourceRequestMarshaller().marshall(listTagsForResourceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new ListTagsForResourceResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns events related to DB Instances, DB Security Groups, DB
     * Snapshots and DB Parameter Groups for the past 14 days. Events
     * specific to a particular DB Instance, DB Security Group, database
     * snapshot or DB Parameter Group can be obtained by providing the name
     * as a parameter. By default, the past hour of events are returned.
     * </p>
     *
     * @param describeEventsRequest Container for the necessary parameters to
     *           execute the DescribeEvents service method on AmazonRDS.
     * 
     * @return The response from the DescribeEvents service method, as
     *         returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventsResult describeEvents(DescribeEventsRequest describeEventsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeEventsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeEventsRequest> request = null;
        DescribeEventsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeEventsRequestMarshaller().marshall(describeEventsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeEventsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new Option Group. You can create up to 20 option groups.
     * </p>
     *
     * @param createOptionGroupRequest Container for the necessary parameters
     *           to execute the CreateOptionGroup service method on AmazonRDS.
     * 
     * @return The response from the CreateOptionGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws OptionGroupAlreadyExistsException
     * @throws OptionGroupQuotaExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public OptionGroup createOptionGroup(CreateOptionGroupRequest createOptionGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createOptionGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateOptionGroupRequest> request = null;
        OptionGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateOptionGroupRequestMarshaller().marshall(createOptionGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new OptionGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new DB subnet group. DB subnet groups must contain at least
     * one subnet in at least two AZs in the region.
     * </p>
     *
     * @param createDBSubnetGroupRequest Container for the necessary
     *           parameters to execute the CreateDBSubnetGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the CreateDBSubnetGroup service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBSubnetQuotaExceededException
     * @throws DBSubnetGroupAlreadyExistsException
     * @throws DBSubnetGroupQuotaExceededException
     * @throws DBSubnetGroupDoesNotCoverEnoughAZsException
     * @throws InvalidSubnetException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSubnetGroup createDBSubnetGroup(CreateDBSubnetGroupRequest createDBSubnetGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBSubnetGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBSubnetGroupRequest> request = null;
        DBSubnetGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBSubnetGroupRequestMarshaller().marshall(createDBSubnetGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSubnetGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of DB log files for the DB instance.
     * </p>
     *
     * @param describeDBLogFilesRequest Container for the necessary
     *           parameters to execute the DescribeDBLogFiles service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBLogFiles service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBLogFilesResult describeDBLogFiles(DescribeDBLogFilesRequest describeDBLogFilesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBLogFilesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBLogFilesRequest> request = null;
        DescribeDBLogFilesResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBLogFilesRequestMarshaller().marshall(describeDBLogFilesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBLogFilesResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Revokes ingress from a DBSecurityGroup for previously authorized IP
     * ranges or EC2 or VPC Security Groups. Required parameters for this API
     * are one of CIDRIP, EC2SecurityGroupId for VPC, or
     * (EC2SecurityGroupOwnerId and either EC2SecurityGroupName or
     * EC2SecurityGroupId).
     * </p>
     *
     * @param revokeDBSecurityGroupIngressRequest Container for the necessary
     *           parameters to execute the RevokeDBSecurityGroupIngress service method
     *           on AmazonRDS.
     * 
     * @return The response from the RevokeDBSecurityGroupIngress service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBSecurityGroupNotFoundException
     * @throws InvalidDBSecurityGroupStateException
     * @throws AuthorizationNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBSecurityGroup revokeDBSecurityGroupIngress(RevokeDBSecurityGroupIngressRequest revokeDBSecurityGroupIngressRequest) {
        ExecutionContext executionContext = createExecutionContext(revokeDBSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RevokeDBSecurityGroupIngressRequest> request = null;
        DBSecurityGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RevokeDBSecurityGroupIngressRequestMarshaller().marshall(revokeDBSecurityGroupIngressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBSecurityGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Modifies an existing RDS event notification subscription. Note that
     * you cannot modify the source identifiers using this call; to change
     * source identifiers for a subscription, use the
     * AddSourceIdentifierToSubscription and
     * RemoveSourceIdentifierFromSubscription calls.
     * </p>
     * <p>
     * You can see a list of the event categories for a given SourceType in
     * the <a
     * tp://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Events.html">
     * Events </a> topic in the Amazon RDS User Guide or by using the
     * <b>DescribeEventCategories</b> action.
     * </p>
     *
     * @param modifyEventSubscriptionRequest Container for the necessary
     *           parameters to execute the ModifyEventSubscription service method on
     *           AmazonRDS.
     * 
     * @return The response from the ModifyEventSubscription service method,
     *         as returned by AmazonRDS.
     * 
     * @throws SNSTopicArnNotFoundException
     * @throws SNSInvalidTopicException
     * @throws SubscriptionCategoryNotFoundException
     * @throws SubscriptionNotFoundException
     * @throws SNSNoAuthorizationException
     * @throws EventSubscriptionQuotaExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EventSubscription modifyEventSubscription(ModifyEventSubscriptionRequest modifyEventSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyEventSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyEventSubscriptionRequest> request = null;
        EventSubscription response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyEventSubscriptionRequestMarshaller().marshall(modifyEventSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EventSubscriptionStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of DBParameterGroup descriptions. If a
     * DBParameterGroupName is specified, the list will contain only the
     * description of the specified DBParameterGroup.
     * </p>
     *
     * @param describeDBParameterGroupsRequest Container for the necessary
     *           parameters to execute the DescribeDBParameterGroups service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBParameterGroups service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBParameterGroupsResult describeDBParameterGroups(DescribeDBParameterGroupsRequest describeDBParameterGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBParameterGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBParameterGroupsRequest> request = null;
        DescribeDBParameterGroupsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBParameterGroupsRequestMarshaller().marshall(describeDBParameterGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBParameterGroupsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes an RDS event notification subscription.
     * </p>
     *
     * @param deleteEventSubscriptionRequest Container for the necessary
     *           parameters to execute the DeleteEventSubscription service method on
     *           AmazonRDS.
     * 
     * @return The response from the DeleteEventSubscription service method,
     *         as returned by AmazonRDS.
     * 
     * @throws SubscriptionNotFoundException
     * @throws InvalidEventSubscriptionStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EventSubscription deleteEventSubscription(DeleteEventSubscriptionRequest deleteEventSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteEventSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteEventSubscriptionRequest> request = null;
        EventSubscription response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteEventSubscriptionRequestMarshaller().marshall(deleteEventSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EventSubscriptionStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Purchases a reserved DB Instance offering.
     * </p>
     *
     * @param purchaseReservedDBInstancesOfferingRequest Container for the
     *           necessary parameters to execute the
     *           PurchaseReservedDBInstancesOffering service method on AmazonRDS.
     * 
     * @return The response from the PurchaseReservedDBInstancesOffering
     *         service method, as returned by AmazonRDS.
     * 
     * @throws ReservedDBInstancesOfferingNotFoundException
     * @throws ReservedDBInstanceQuotaExceededException
     * @throws ReservedDBInstanceAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ReservedDBInstance purchaseReservedDBInstancesOffering(PurchaseReservedDBInstancesOfferingRequest purchaseReservedDBInstancesOfferingRequest) {
        ExecutionContext executionContext = createExecutionContext(purchaseReservedDBInstancesOfferingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<PurchaseReservedDBInstancesOfferingRequest> request = null;
        ReservedDBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new PurchaseReservedDBInstancesOfferingRequestMarshaller().marshall(purchaseReservedDBInstancesOfferingRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new ReservedDBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a new DB Parameter Group.
     * </p>
     * <p>
     * A DB Parameter Group is initially created with the default parameters
     * for the database engine used by the DB Instance. To provide custom
     * values for any of the parameters, you must modify the group after
     * creating it using <i>ModifyDBParameterGroup</i> . Once you've created
     * a DB Parameter Group, you need to associate it with your DB Instance
     * using <i>ModifyDBInstance</i> . When you associate a new DB Parameter
     * Group with a running DB Instance, you need to reboot the DB Instance
     * for the new DB Parameter Group and associated settings to take effect.
     * </p>
     *
     * @param createDBParameterGroupRequest Container for the necessary
     *           parameters to execute the CreateDBParameterGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the CreateDBParameterGroup service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBParameterGroupQuotaExceededException
     * @throws DBParameterGroupAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBParameterGroup createDBParameterGroup(CreateDBParameterGroupRequest createDBParameterGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createDBParameterGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateDBParameterGroupRequest> request = null;
        DBParameterGroup response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateDBParameterGroupRequestMarshaller().marshall(createDBParameterGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBParameterGroupStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes an existing Option Group.
     * </p>
     *
     * @param deleteOptionGroupRequest Container for the necessary parameters
     *           to execute the DeleteOptionGroup service method on AmazonRDS.
     * 
     * @throws InvalidOptionGroupStateException
     * @throws OptionGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteOptionGroup(DeleteOptionGroupRequest deleteOptionGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteOptionGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteOptionGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteOptionGroupRequestMarshaller().marshall(deleteOptionGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Downloads the last line of the specified log file.
     * </p>
     *
     * @param downloadDBLogFilePortionRequest Container for the necessary
     *           parameters to execute the DownloadDBLogFilePortion service method on
     *           AmazonRDS.
     * 
     * @return The response from the DownloadDBLogFilePortion service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DownloadDBLogFilePortionResult downloadDBLogFilePortion(DownloadDBLogFilePortionRequest downloadDBLogFilePortionRequest) {
        ExecutionContext executionContext = createExecutionContext(downloadDBLogFilePortionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DownloadDBLogFilePortionRequest> request = null;
        DownloadDBLogFilePortionResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DownloadDBLogFilePortionRequestMarshaller().marshall(downloadDBLogFilePortionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DownloadDBLogFilePortionResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a DB Security Group.
     * </p>
     * <p>
     * <b>NOTE:</b>The specified DB Security Group must not be associated
     * with any DB Instances.
     * </p>
     *
     * @param deleteDBSecurityGroupRequest Container for the necessary
     *           parameters to execute the DeleteDBSecurityGroup service method on
     *           AmazonRDS.
     * 
     * @throws DBSecurityGroupNotFoundException
     * @throws InvalidDBSecurityGroupStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteDBSecurityGroup(DeleteDBSecurityGroupRequest deleteDBSecurityGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDBSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDBSecurityGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteDBSecurityGroupRequestMarshaller().marshall(deleteDBSecurityGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Modify settings for a DB Instance. You can change one or more
     * database configuration parameters by specifying these parameters and
     * the new values in the request.
     * </p>
     *
     * @param modifyDBInstanceRequest Container for the necessary parameters
     *           to execute the ModifyDBInstance service method on AmazonRDS.
     * 
     * @return The response from the ModifyDBInstance service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws DBInstanceAlreadyExistsException
     * @throws DBInstanceNotFoundException
     * @throws StorageQuotaExceededException
     * @throws InvalidVPCNetworkStateException
     * @throws InvalidDBInstanceStateException
     * @throws DBSecurityGroupNotFoundException
     * @throws InvalidDBSecurityGroupStateException
     * @throws InsufficientDBInstanceCapacityException
     * @throws DBUpgradeDependencyFailureException
     * @throws OptionGroupNotFoundException
     * @throws ProvisionedIopsNotAvailableInAZException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance modifyDBInstance(ModifyDBInstanceRequest modifyDBInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyDBInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyDBInstanceRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyDBInstanceRequestMarshaller().marshall(modifyDBInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Adds a source identifier to an existing RDS event notification
     * subscription.
     * </p>
     *
     * @param addSourceIdentifierToSubscriptionRequest Container for the
     *           necessary parameters to execute the AddSourceIdentifierToSubscription
     *           service method on AmazonRDS.
     * 
     * @return The response from the AddSourceIdentifierToSubscription
     *         service method, as returned by AmazonRDS.
     * 
     * @throws SourceNotFoundException
     * @throws SubscriptionNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public EventSubscription addSourceIdentifierToSubscription(AddSourceIdentifierToSubscriptionRequest addSourceIdentifierToSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(addSourceIdentifierToSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AddSourceIdentifierToSubscriptionRequest> request = null;
        EventSubscription response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AddSourceIdentifierToSubscriptionRequestMarshaller().marshall(addSourceIdentifierToSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new EventSubscriptionStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the available option groups.
     * </p>
     *
     * @param describeOptionGroupsRequest Container for the necessary
     *           parameters to execute the DescribeOptionGroups service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeOptionGroups service method, as
     *         returned by AmazonRDS.
     * 
     * @throws OptionGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeOptionGroupsResult describeOptionGroups(DescribeOptionGroupsRequest describeOptionGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeOptionGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeOptionGroupsRequest> request = null;
        DescribeOptionGroupsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeOptionGroupsRequestMarshaller().marshall(describeOptionGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeOptionGroupsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns a list of DBSecurityGroup descriptions. If a
     * DBSecurityGroupName is specified, the list will contain only the
     * descriptions of the specified DBSecurityGroup.
     * </p>
     * <p>
     * For an overview of CIDR ranges, go to the <a
     * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
     * Wikipedia Tutorial </a> .
     * </p>
     *
     * @param describeDBSecurityGroupsRequest Container for the necessary
     *           parameters to execute the DescribeDBSecurityGroups service method on
     *           AmazonRDS.
     * 
     * @return The response from the DescribeDBSecurityGroups service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBSecurityGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSecurityGroupsResult describeDBSecurityGroups(DescribeDBSecurityGroupsRequest describeDBSecurityGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeDBSecurityGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeDBSecurityGroupsRequest> request = null;
        DescribeDBSecurityGroupsResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeDBSecurityGroupsRequestMarshaller().marshall(describeDBSecurityGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DescribeDBSecurityGroupsResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DeleteDBInstance action deletes a previously provisioned DB
     * instance. A successful response from the web service indicates the
     * request was received correctly. When you delete a DB instance, all
     * automated backups for that instance are deleted and cannot be
     * recovered. Manual DB Snapshots of the DB instance to be deleted are
     * not deleted.
     * </p>
     * <p>
     * If a final DBSnapshot is requested the status of the RDS instance
     * will be "deleting" until the DBSnapshot is created. DescribeDBInstance
     * is used to monitor the status of this operation. This cannot be
     * canceled or reverted once submitted.
     * </p>
     *
     * @param deleteDBInstanceRequest Container for the necessary parameters
     *           to execute the DeleteDBInstance service method on AmazonRDS.
     * 
     * @return The response from the DeleteDBInstance service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws InvalidDBInstanceStateException
     * @throws SnapshotQuotaExceededException
     * @throws DBSnapshotAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance deleteDBInstance(DeleteDBInstanceRequest deleteDBInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteDBInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteDBInstanceRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteDBInstanceRequestMarshaller().marshall(deleteDBInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Removes metadata tags from a DB Instance.
     * </p>
     * <p>
     * For an overview on tagging DB Instances, see <a
     * docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Tagging.html">
     * DB Instance Tags. </a>
     * </p>
     *
     * @param removeTagsFromResourceRequest Container for the necessary
     *           parameters to execute the RemoveTagsFromResource service method on
     *           AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void removeTagsFromResource(RemoveTagsFromResourceRequest removeTagsFromResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(removeTagsFromResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RemoveTagsFromResourceRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RemoveTagsFromResourceRequestMarshaller().marshall(removeTagsFromResourceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Modifies the parameters of a DBParameterGroup. To modify more than
     * one parameter submit a list of the following: ParameterName,
     * ParameterValue, and ApplyMethod. A maximum of 20 parameters can be
     * modified in a single request.
     * </p>
     * <p>
     * <b>NOTE:</b> The apply-immediate method can be used only for dynamic
     * parameters; the pending-reboot method can be used with MySQL and
     * Oracle DB Instances for either dynamic or static parameters. For
     * Microsoft SQL Server DB Instances, the pending-reboot method can be
     * used only for static parameters.
     * </p>
     *
     * @param modifyDBParameterGroupRequest Container for the necessary
     *           parameters to execute the ModifyDBParameterGroup service method on
     *           AmazonRDS.
     * 
     * @return The response from the ModifyDBParameterGroup service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     * @throws InvalidDBParameterGroupStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ModifyDBParameterGroupResult modifyDBParameterGroup(ModifyDBParameterGroupRequest modifyDBParameterGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyDBParameterGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyDBParameterGroupRequest> request = null;
        ModifyDBParameterGroupResult response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyDBParameterGroupRequestMarshaller().marshall(modifyDBParameterGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new ModifyDBParameterGroupResultStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Reboots a previously provisioned RDS instance. This API results in
     * the application of modified DBParameterGroup parameters with
     * ApplyStatus of pending-reboot to the RDS instance. This action is
     * taken as soon as possible, and results in a momentary outage to the
     * RDS instance during which the RDS instance status is set to rebooting.
     * If the RDS instance is configured for MultiAZ, it is possible that the
     * reboot will be conducted through a failover. A DBInstance event is
     * created when the reboot is completed.
     * </p>
     *
     * @param rebootDBInstanceRequest Container for the necessary parameters
     *           to execute the RebootDBInstance service method on AmazonRDS.
     * 
     * @return The response from the RebootDBInstance service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     * @throws InvalidDBInstanceStateException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DBInstance rebootDBInstance(RebootDBInstanceRequest rebootDBInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(rebootDBInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RebootDBInstanceRequest> request = null;
        DBInstance response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RebootDBInstanceRequestMarshaller().marshall(rebootDBInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            return response = invoke(request, new DBInstanceStaxUnmarshaller(), executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns information about reserved DB Instances for this account, or
     * about a specified reserved DB Instance.
     * </p>
     * 
     * @return The response from the DescribeReservedDBInstances service
     *         method, as returned by AmazonRDS.
     * 
     * @throws ReservedDBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedDBInstancesResult describeReservedDBInstances() throws AmazonServiceException, AmazonClientException {
        return describeReservedDBInstances(new DescribeReservedDBInstancesRequest());
    }
    
    /**
     * <p>
     * Displays a list of categories for all event source types, or, if
     * specified, for a specified source type. You can see a list of the
     * event categories and source types in the <a
     * tp://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Events.html">
     * Events </a> topic in the Amazon RDS User Guide.
     * </p>
     * 
     * @return The response from the DescribeEventCategories service method,
     *         as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventCategoriesResult describeEventCategories() throws AmazonServiceException, AmazonClientException {
        return describeEventCategories(new DescribeEventCategoriesRequest());
    }
    
    /**
     * <p>
     * Lists available reserved DB Instance offerings.
     * </p>
     * 
     * @return The response from the DescribeReservedDBInstancesOfferings
     *         service method, as returned by AmazonRDS.
     * 
     * @throws ReservedDBInstancesOfferingNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings() throws AmazonServiceException, AmazonClientException {
        return describeReservedDBInstancesOfferings(new DescribeReservedDBInstancesOfferingsRequest());
    }
    
    /**
     * <p>
     * Returns information about provisioned RDS instances. This API
     * supports pagination.
     * </p>
     * 
     * @return The response from the DescribeDBInstances service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBInstancesResult describeDBInstances() throws AmazonServiceException, AmazonClientException {
        return describeDBInstances(new DescribeDBInstancesRequest());
    }
    
    /**
     * <p>
     * Returns a list of the available DB engines.
     * </p>
     * 
     * @return The response from the DescribeDBEngineVersions service method,
     *         as returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBEngineVersionsResult describeDBEngineVersions() throws AmazonServiceException, AmazonClientException {
        return describeDBEngineVersions(new DescribeDBEngineVersionsRequest());
    }
    
    /**
     * <p>
     * Returns information about DBSnapshots. This API supports pagination.
     * </p>
     * 
     * @return The response from the DescribeDBSnapshots service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBSnapshotNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSnapshotsResult describeDBSnapshots() throws AmazonServiceException, AmazonClientException {
        return describeDBSnapshots(new DescribeDBSnapshotsRequest());
    }
    
    /**
     * <p>
     * Returns a list of DBSubnetGroup descriptions. If a DBSubnetGroupName
     * is specified, the list will contain only the descriptions of the
     * specified DBSubnetGroup.
     * </p>
     * <p>
     * For an overview of CIDR ranges, go to the <a
     * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
     * Wikipedia Tutorial </a> .
     * </p>
     * 
     * @return The response from the DescribeDBSubnetGroups service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBSubnetGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSubnetGroupsResult describeDBSubnetGroups() throws AmazonServiceException, AmazonClientException {
        return describeDBSubnetGroups(new DescribeDBSubnetGroupsRequest());
    }
    
    /**
     * <p>
     * Lists all the subscription descriptions for a customer account. The
     * description for a subscription includes SubscriptionName, SNSTopicARN,
     * CustomerID, SourceType, SourceID, CreationTime, and Status.
     * </p>
     * <p>
     * If you specify a SubscriptionName, lists the description for that
     * subscription.
     * </p>
     * 
     * @return The response from the DescribeEventSubscriptions service
     *         method, as returned by AmazonRDS.
     * 
     * @throws SubscriptionNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventSubscriptionsResult describeEventSubscriptions() throws AmazonServiceException, AmazonClientException {
        return describeEventSubscriptions(new DescribeEventSubscriptionsRequest());
    }
    
    /**
     * <p>
     * Returns events related to DB Instances, DB Security Groups, DB
     * Snapshots and DB Parameter Groups for the past 14 days. Events
     * specific to a particular DB Instance, DB Security Group, database
     * snapshot or DB Parameter Group can be obtained by providing the name
     * as a parameter. By default, the past hour of events are returned.
     * </p>
     * 
     * @return The response from the DescribeEvents service method, as
     *         returned by AmazonRDS.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeEventsResult describeEvents() throws AmazonServiceException, AmazonClientException {
        return describeEvents(new DescribeEventsRequest());
    }
    
    /**
     * <p>
     * Returns a list of DB log files for the DB instance.
     * </p>
     * 
     * @return The response from the DescribeDBLogFiles service method, as
     *         returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBLogFilesResult describeDBLogFiles() throws AmazonServiceException, AmazonClientException {
        return describeDBLogFiles(new DescribeDBLogFilesRequest());
    }
    
    /**
     * <p>
     * Returns a list of DBParameterGroup descriptions. If a
     * DBParameterGroupName is specified, the list will contain only the
     * description of the specified DBParameterGroup.
     * </p>
     * 
     * @return The response from the DescribeDBParameterGroups service
     *         method, as returned by AmazonRDS.
     * 
     * @throws DBParameterGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBParameterGroupsResult describeDBParameterGroups() throws AmazonServiceException, AmazonClientException {
        return describeDBParameterGroups(new DescribeDBParameterGroupsRequest());
    }
    
    /**
     * <p>
     * Downloads the last line of the specified log file.
     * </p>
     * 
     * @return The response from the DownloadDBLogFilePortion service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBInstanceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DownloadDBLogFilePortionResult downloadDBLogFilePortion() throws AmazonServiceException, AmazonClientException {
        return downloadDBLogFilePortion(new DownloadDBLogFilePortionRequest());
    }
    
    /**
     * <p>
     * Describes the available option groups.
     * </p>
     * 
     * @return The response from the DescribeOptionGroups service method, as
     *         returned by AmazonRDS.
     * 
     * @throws OptionGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeOptionGroupsResult describeOptionGroups() throws AmazonServiceException, AmazonClientException {
        return describeOptionGroups(new DescribeOptionGroupsRequest());
    }
    
    /**
     * <p>
     * Returns a list of DBSecurityGroup descriptions. If a
     * DBSecurityGroupName is specified, the list will contain only the
     * descriptions of the specified DBSecurityGroup.
     * </p>
     * <p>
     * For an overview of CIDR ranges, go to the <a
     * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
     * Wikipedia Tutorial </a> .
     * </p>
     * 
     * @return The response from the DescribeDBSecurityGroups service method,
     *         as returned by AmazonRDS.
     * 
     * @throws DBSecurityGroupNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRDS indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeDBSecurityGroupsResult describeDBSecurityGroups() throws AmazonServiceException, AmazonClientException {
        return describeDBSecurityGroups(new DescribeDBSecurityGroupsRequest());
    }
    
    /**
     * Overrides the default endpoint for this client ("https://rds.amazonaws.com") and explicitly provides
     * an AWS region ID and AWS service name to use when the client calculates a signature
     * for requests.  In almost all cases, this region ID and service name
     * are automatically determined from the endpoint, and callers should use the simpler
     * one-argument form of setEndpoint instead of this method.
     * <p>
     * <b>This method is not threadsafe. Endpoints should be configured when the
     * client is created and before any service requests are made. Changing it
     * afterwards creates inevitable race conditions for any service requests in
     * transit.</b>
     * <p>
     * Callers can pass in just the endpoint (ex: "rds.amazonaws.com") or a full
     * URL, including the protocol (ex: "https://rds.amazonaws.com"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     * <p>
     * For more information on using AWS regions with the AWS SDK for Java, and
     * a complete list of all available endpoints for all AWS services, see:
     * <a href="http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912">
     * http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912</a>
     *
     * @param endpoint
     *            The endpoint (ex: "rds.amazonaws.com") or a full URL,
     *            including the protocol (ex: "https://rds.amazonaws.com") of
     *            the region specific AWS endpoint this client will communicate
     *            with.
     * @param serviceName
     *            The name of the AWS service to use when signing requests.
     * @param regionId
     *            The ID of the region in which this service resides.
     *
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     */
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        setEndpoint(endpoint);
        signer.setServiceName(serviceName);
        signer.setRegionName(regionId);
    }
    
    @Override
    protected String getServiceAbbreviation() {
        return "rds";
    }
    

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        for (Entry<String, String> entry : originalRequest.copyPrivateRequestParameters().entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setSigner(signer);
        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return (X)client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        